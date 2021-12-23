<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/12/23
  Time: 8:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="auth/mail">

<input  name="email" type="text" /><input type="submit" value="发送邮件"/><br/>

</form>

<form action="auth/phone">
<input  name="phone" type="text" value="15173076553" readonly="readonly" /><input type="submit"  value="发送短信" disabled /><br/>
</form>

<form action="alipay/prepay">
    <input  name="orderNo" type="text"  /><input type="submit"  value="支付宝"/><br/>
</form>

    <input  class="vxOrderNo" type="text"  /><input type="button"  class="vx" value="微信"/><br/>

    <div id="ma">


    </div>

</body>
<script src="statics/jquery.min.js"></script>
<script src="statics/qrcode.min.js"></script>
<script>

    $(".vx").click(function () {
        var order=$(".vxOrderNo").val();
        $.getJSON("${pageContext.request.contextPath }/wxpay/createqccode/"+order,function (data) {
            new QRCode(document.getElementById('ma'),data.codeUrl);
        });

    });
$(function () {




});


</script>
</html>
