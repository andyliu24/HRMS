<%--
  Created by IntelliJ IDEA.
  User: liumengxiao
  Date: 18/7/12
  Time: 7:04 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="description" content="人力资源管理系统，通过提高内部员工的满意度、忠诚度，从而提高绩效，帮助管理者通过有效组织管理降低成本和加速增长来创造价值链利润。人力资源综合管理解决方案从人力资源管理的角度出发，用集中的数据将几乎所有与人力资源相关的信息统一管理起来……">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="keywords" content="人力资源管理，人力资源管理系统">
    <meta name="viewport" content="width=device-width,initial-scale=1.0,maximum-scale=1.0，user-scalable=no">
    <title>人力资源管理系统 - 用户登录</title>
    <link rel="stylesheet" href="css/login.css">
    <link rel="stylesheet" href="fonts/css/font-awesome.min.css" />
    <style>
        body{
            margin: 0px;
            padding: 0px;
            background: url(img/bg.jpg) no-repeat;
            background-attachment: fixed;
            background-size: cover;
        }
    </style>
    <!--[if lt IE 9]>
    <script src="https://cdn.bootcss.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    <script src="js/hide_and_show_password.js" type="text/javascript" charset="utf-8"></script>

    <!-- MD5加密 -->
    <script src="js/md5.min.js"></script>
    <script>
        function md5_encode() {
            var password = document.getElementById("password");
            var password_md5 = document.getElementById("password_md5");
            password_md5.value = md5(password.value);
            return true;
        }
    </script>

</head>
<body>
<div class="box">
    <div class="left_box">

    </div>
    <div>
        <div class="right_box">
            <div class="user-login">
                <h1>用户登录</h1>
                <form class="login" method="post" action="login" onsubmit="md5_encode()">
                    <li class="base">
                        <input type="text" name="username" style="color: white;" placeholder="用户名"><i style="color: white;"  class="fa fa-user"></i>
                    </li>
                    <li class="base">
                        <input type="password" id="password" style="color: white;" placeholder="密码"><i id="ico" style="color: white;" class="fa fa-lock" onclick="hideShowPwd()"></i>
                        <input type="hidden" id="password_md5" name="password"/>
                    </li>
                    <input type="submit" name="submit-login" value="登录">
                </form>
            </div>
        </div>
    </div>
</body>
</html>
