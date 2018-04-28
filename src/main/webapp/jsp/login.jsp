<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    request.setAttribute("path",request.getContextPath());
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">

    <title>登陆页面</title>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <!--
    <link rel="stylesheet" type="text/css" href="styles.css">
    -->
    <script src="${path}/WEB-INF/js/jQuery-2.1.4.min.js"></script>

    <script type="text/javascript">

        var _path = "${path}";
        window.onload = function(){
            change();
        }
        function change(){
            var img =document.getElementById("verify");
            img.src=_path+"/getVerifyCode.do?a="+new Date().getTime();
        }
    </script>
</head>

<body>
<center>
    <div>
        <h1>欢迎登陆</h1>
        <form action="${path}/login.do" method="post">
            <table>
                <tr>
                    <td width="66" align="right"><font size="3">帐号：</font></td><td colspan="2"><input type="text" id="staffCode" name="staffCode" value="${staffDO.staffCode }" style="width:200;height:25;"/></td>
                </tr>
                <tr>
                    <td align="right"><font size="3">密码：</font></td><td colspan="2"><input type="password" id="password" name="password"  style="width:200;height:25;"/></td>
                </tr>
                <tr>
                    <td align="right"><font size="3">验证码：</font></td>
                    <td width="108" valign="middle"><input type="text" id="verifycode" name="verifycode" style="width:100;height:25;"/></td>
                    <td width="90" valign="middle"><a href="javascript:change()"><img id="verify" border="0"></a></td>
                </tr>
                <tr><td colspan="3" align="center"><input type="submit" value="登录" style="width:130;height:30;"/></td></tr>
            </table>
        </form>
        <a href="regist.jsp"><font size="2"><i>没有帐号？点击注册</i></font></a>
        <font color="red" size="2"> ${msg }</font>
    </div>
</center>
</body>
</html>