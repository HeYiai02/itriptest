package controller;

import cn.itrip.common.MD5;
import com.cloopen.rest.sdk.CCPRestSmsSDK;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Controller
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    MailSender mailSender;
    @Autowired
    SimpleMailMessage mailMessage;
    @RequestMapping("/mail")
    @ResponseBody
    public void sendMail(String email){
    int random= MD5.getRandomCode();
        mailMessage.setTo(email);
        mailMessage.setText("你的验证码是:"+MD5.getMd5(String.valueOf(random),10));
        mailSender.send(mailMessage);
    }


    @RequestMapping("/phone")
    @ResponseBody
    public void sendSms(String phone){
        int code= MD5.getRandomCode();
        //发送验证码(发送的数据，有效时间)
        String datas[]={String.valueOf(code),"5"};
        CCPRestSmsSDK sms=new CCPRestSmsSDK();
        sms.init("app.cloopen.com","8883");
        sms.setAppId("8aaf07087d55e4d9017d6f5ad200050f");
        sms.setAccount("8aaf07087d55e4d9017d6f5ad1060509","676736148f514229878eaf0b75ccbbcf");
        //发送短信
        sms.sendTemplateSMS(phone, "1", datas);
    }

}
