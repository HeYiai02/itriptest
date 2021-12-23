package controller;

import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import wxutils.WXPayConstants;
import wxutils.WXPayRequest;
import wxutils.WXPayUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/wxpay")
public class WxPayController {



    @RequestMapping("/createqccode/{orderNo}")
    @ResponseBody
    public String createCode(@PathVariable String orderNo){
        Map<String,String> map=new HashMap<String,String>();
        map.put("appid","wxab8acb865bb1637e");
        map.put("mch_id","11473623");
        map.put("nonce_str", WXPayUtil.generateNonceStr());
//        map.put("sign","");
        map.put("body","爱旅行微信支付");
        map.put("out_trade_no",orderNo);
        map.put("total_fee","1");
        map.put("spbill_create_ip","192.168.1.1");
        map.put("notify_url","http://heyiai.nat300.top/youwang/wxpay/notify");
        map.put("trade_type","NATIVE");
        try{
            String requestXML=WXPayUtil.generateSignedXml(map,"2ab9071b06b9f739b950ddb41db2690d", WXPayConstants.SignType.MD5);
            String responseXML= WXPayRequest.requestByXml("https://api.mch.weixin.qq.com/pay/unifiedorder",requestXML);
            Map<String,String> respMap=WXPayUtil.xmlToMap(responseXML);

            Map<String,String> resultMap=new HashMap<String, String>();
            if(respMap.get("return_code").equals("SUCCESS")&&respMap.get("result_code").equals("SUCCESS")){
                String code_url=respMap.get("code_url");
                resultMap.put("codeUrl",code_url);
            }
            return JSON.toJSONString(resultMap);
        }catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }


    @RequestMapping("/notify")
    @ResponseBody
    public void wxNotify(HttpServletResponse response, HttpServletRequest request){
        try{
            StringBuffer sb=new StringBuffer();
            InputStream is=request.getInputStream();
            BufferedReader br=new BufferedReader(new InputStreamReader(is,"UTF-8"));
            String temp;
            while ((temp=br.readLine())!=null){
                sb.append(temp);
            }
            br.close();
            is.close();
            //用map接受vx返回的数据
            Map<String,String> resultMap=WXPayUtil.xmlToMap(sb.toString());

            //验证返回参数是否合法(签名，key)
            boolean flag=WXPayUtil.isSignatureValid(resultMap,"2ab9071b06b9f739b950ddb41db2690d",WXPayConstants.SignType.MD5);
            if(flag){
                if(resultMap.get("return_code").equals("SUCCESS")&&resultMap.get("result_code").equals("SUCCESS")){
                        //返回结果给微信
                        Map<String,String> result=new HashMap<String, String>();
                        result.put("return_code","SUCCESS");
                        result.put("return_msg","SUCCESS");
                        String xml=WXPayUtil.generateSignedXml(result,"2ab9071b06b9f739b950ddb41db2690d",WXPayConstants.SignType.MD5);
                        response.getWriter().write(xml);
                        response.getWriter().flush();
                }

            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }


}
