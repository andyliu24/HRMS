<%--
  Created by IntelliJ IDEA.
  User: Andy Liu
  Date: 18/7/12
  Time: 7:01 PM
--%>

<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="/favicon.ico">

    <title>HRMS人力资源管理系统</title>

    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <link href="assets/css/ie10-viewport-bug-workaround.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="css/dashboard.css" rel="stylesheet">

    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
    <script src="assets/js/ie-emulation-modes-warning.js"></script>

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>

<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="index.jsp">HRMS人力资源管理系统</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav navbar-right">
                <li><a href="index.jsp">首页</a></li>
                <li><a href="setting.jsp" target="main">设置</a></li>
                <li><a href="login?method=logout">退出</a></li>
            </ul>
            <form class="navbar-form navbar-right">
                <input type="text" class="form-control" placeholder="搜索...">
            </form>
        </div>
    </div>
</nav>

<div class="container-fluid">
    <div class="row">
        <div class="col-sm-3 col-md-2 sidebar">
            <ul class="nav nav-sidebar">
                <li><a href="index.jsp">首页<span class="sr-only">(current)</span></a></li>
            </ul>

            <ul class="nav nav-sidebar">
                <li class="active"><a href="#">员工信息管理<span class="sr-only">(current)</span></a></li>
                <li><a href="pages/entry.jsp" target="main">员工入职</a></li>
                <li><a href="pages/dimission.jsp" target="main">员工离职</a></li>
                <li><a href="pages/trial_setting.jsp" target="main">试用期管理</a></li>
                <li><a href="pages/employee_view.jsp" target="main">员工基本信息</a></ldi>
                <li><a href="pages/employee_more_view.jsp" target="main">员工详细资料</a></li>
            </ul>

            <ul class="nav nav-sidebar">
                <li class="active"><a href="#">部门管理<span class="sr-only">(current)</span></a></li>
                <li><a href="pages/department_movement.jsp" target="main">部门调动</a></li>
                <li><a href="pages/department_view.jsp" target="main">部门管理</a></li>
            </ul>

            <ul class="nav nav-sidebar">
                <li class="active"><a href="#">岗位管理<span class="sr-only">(current)</span></a></li>
                <li><a href="pages/position_movement.jsp" target="main">岗位调动</a></li>
                <li><a href="pages/position_view.jsp" target="main">岗位管理</a></li>
            </ul>

            <ul class="nav nav-sidebar">
                <li class="active"><a href="#">报表管理<span class="sr-only">(current)</span></a></li>
                <li><a href="pages/report_new_employee.jsp" target="main">新聘员工表</a></li>
                <li><a href="pages/report_dismiss_employee.jsp" target="main">离职员工表</a></li>
                <li><a href="pages/report_department_movement.jsp" target="main">部门调动表</a></li>
                <li><a href="pages/report_position_movement.jsp" target="main">岗位调动表</a></li>
                <li><a href="pages/report_hr_salary.jsp" target="main">人事月报表</a></li>
            </ul>
        </div>
        <!-- -->
        <div style="padding: 0px;" class="col-sm-9 col-sm-offset-3 col-md-10  col-md-offset-2 main">
            <iframe name="main" src="pages/main?method=info" frameborder="0" height="100%" width="100%"></iframe>
        </div>

        <!-- Bootstrap core JavaScript
        ================================================== -->
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="js/jquery.min.js"></script>
        <script>window.jQuery || document.write('<script src="assets/js/vendor/jquery.min.js"><\/script>')</script>
        <script src="js/bootstrap.min.js"></script>
        <!-- Just to make our placeholder images work. Don't actually copy the next line! -->
        <script src="assets/js/vendor/holder.min.js"></script>
        <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
        <script src="assets/js/ie10-viewport-bug-workaround.js"></script>
</body>
</html>
