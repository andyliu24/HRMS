<%@ page import="java.io.PrintWriter" %><%--
  Created by IntelliJ IDEA.
  User: Andy Liu
  Date: 18/7/12
  Time: 8:10 PM
--%>
<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>设置</title>

    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <link href="assets/css/ie10-viewport-bug-workaround.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="css/dashboard.css" rel="stylesheet">

    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <!--[if lt IE 9]><script src="assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
    <script src="assets/js/ie-emulation-modes-warning.js"></script>

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->

    <!-- MD5加密 -->
    <script src="js/md5.min.js"></script>
    <script>
        function md5_encode() {
            var password = document.getElementById("old_password");
            var password_md5 = document.getElementById("old_password_md5");
            var password_new = document.getElementById("new_password");
            var password_new_md5 = document.getElementById("new_password_md5");
            password_md5.value = md5(password.value);
            password_new_md5.value = md5(password_new.value);
            return true;
        }
    </script>
    
</head>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <h3>
                设置
            </h3>
            <div style="height: 2em;"></div>
            <blockquote>
                <p>
                    请务必牢记您的账号密码，一旦忘记将无法找回！
                </p>
            </blockquote>
            <div class="panel-group" id="panel-211211">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <a class="panel-title collapsed" data-toggle="collapse" data-parent="#panel-211211" href="#panel-element-951040">修改用户姓名</a>
                    </div>
                    <div id="panel-element-951040" class="panel-collapse collapse">
                        <div class="panel-body">
                            <form role="form" id="change_name" class="form-inline" name="change_name" method="post" action="setting">
                                <div class="form-group">
                                    <label for="new_name">新名字*：&nbsp;</label><input type="text" class="form-control" name="new_name" required="required"/>
                                </div>&nbsp;&nbsp;
                                <button type="submit" class="btn btn-default">更改！</button>
                            </form>
                        </div>
                    </div>
                </div>
                <div style="height: 0.5em;"></div>
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <a class="panel-title" data-toggle="collapse" data-parent="#panel-211211" href="#panel-element-422222">修改用户密码</a>
                    </div>
                    <div id="panel-element-422222" class="panel-collapse in">
                        <div class="panel-body">
                            <form role="form" id="change_password" class="form-inline" name="change_password" method="post" action="setting" onsubmit="md5_encode()">
                                <div class="form-group">
                                    <label for="old_password">原密码*：&nbsp;</label>
                                    <input type="password" class="form-control" id="old_password"  required="required" />
                                    <input type="hidden" id="old_password_md5" name="old_password"/>
                                </div>&nbsp;&nbsp;&nbsp;&nbsp;
                                <div class="form-group">
                                    <label for="new_password">新密码*：&nbsp;</label>
                                    <input type="password" class="form-control" id="new_password" required="required" />
                                    <input type="hidden" id="new_password_md5" name="new_password"/>
                                </div>&nbsp;&nbsp;

                                <button type="submit" class="btn btn-default">更改！</button>
                            </form>

                        </div>
                    </div>
                </div>
            </div>

            <div id="show_alert_username" class="alert alert-success alert-dismissable" style="display: none">
                <button type="button" class="close" data-dismiss="alert" >×</button>
                <h4>
                    成功！
                </h4>
                您的姓名已经修改成功！
            </div>

            <div id="show_alert_password" class="alert alert-success alert-dismissable" style="display: none">
                <button type="button" class="close" data-dismiss="alert" >×</button>
                <h4>
                    成功！
                </h4>
                您的密码已经修改成功！
            </div>

            <div id="alert_password_wrong" class="alert alert-warning alert-dismissable" style="display: none">
                <button type="button" class="close" data-dismiss="alert" >×</button>
                <h4>
                    失败
                </h4>
                您输入的原密码不正确，密码修改失败！
            </div>

            <script>
                var status = <%=request.getAttribute("status")%>;

                if (status==1){
                    document.getElementById("show_alert_password").style.display="block";
                }
                if (status==0){
                    document.getElementById("show_alert_username").style.display="block";
                }
                if (status==-1){
                    document.getElementById("alert_password_wrong").style.display="block";
                }
            </script>
            
            </div>
    </div>
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


<%--    <script>
       $('#change_password').submit(function () {
           $.post('http://localhost:8080/hrms/setting',$('#change_password').serialize(),function (data) {
               if(data.status=="success"){
                   console.log(data.status);
                    $('#alert').show();
               }
           });
       });
    </script>--%>


</body>
</html>
