<%@ page import="com.hrms.entity.Employee" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
	<head>
		<meta charset="UTF-8">
		<title>主界面</title>
			
	    <!-- Bootstrap core CSS -->
	    <link href="../css/bootstrap.min.css" rel="stylesheet" media="screen">
	
	    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
	    <link href="../assets/css/ie10-viewport-bug-workaround.css" rel="stylesheet">
	
	    <!-- Custom styles for this template -->
	    <link href="../css/dashboard.css" rel="stylesheet">
	
	    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
	    <!--[if lt IE 9]><script src="../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
	    <script src="../assets/js/ie-emulation-modes-warning.js"></script>
	
	    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
	    <!--[if lt IE 9]>
	      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
	      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
	    <![endif]-->
	    
	    <!-- Time Picker CSS-->
        <link href="../css/bootstrap-datetimepicker.min.css" rel="stylesheet" media="screen">
		<style>
			@media screen and (min-width:990px) {
				.form-control{
				width: 42%;
				}
			}

		</style>
	</head>
	<body>
	<div class="container">
	<div class="row clearfix">
		<div class="col-md-12 column">
			<h3>
				员工信息
			</h3>
			<div style="height: 2em;"></div>
			<ul class="nav nav-tabs">
				<li class="active">
					 <a href="employee_view.jsp">员工信息查询</a>
				</li>
				<li>
					 <a href="employee_modify.jsp">员工信息修改</a>
				</li>
			</ul>
			<div style="height: 2em;"></div>
			<form role="form" method="post" action="employee_view">
				<div class="form-group">
					 <label for="id">员工编号*</label><input type="number" class="form-control" id="id" name="id" required="required" size="15" />
				</div>
			   <button type="submit" class="btn btn-default">查询</button>&nbsp;&nbsp;
			   <button type="reset" class="btn btn-default">重置</button>
			</form>
			<div style="height: 2em;"></div>
			<form role="form">
					<div class="form-group">
					 <label for="department_id">部门编号</label><input type="number" class="form-control" id="department_id" value="${employee.department_id}"readonly="readonly" />
				</div>
				<div class="form-group">
					 <label for="position_id">岗位编号</label><input type="number" class="form-control" id="position_id" value="${employee.position_id}"readonly="readonly" />
				</div>
				<div class="form-group">
						<label for="name">姓名</label><input type="text" class="form-control" id="name" value="${employee.name}" readonly="readonly" />
				</div>
				<div class="form-group">
					 <label for="gender">性别</label><input type="text" class="form-control" id="gender" value="${employee.sex}"readonly="readonly" />
				</div><p/>
				<div class="form-group">
					 <label for="telephone">电话</label><input type="number" class="form-control" id="telephone" value="${employee.telephone}" readonly="readonly"/>
				</div>
				<div class="form-group">
					 <label for="salary">月薪</label><input type="number" class="form-control" id="salary" value="${employee.salary}" readonly="readonly"/>
				</div>
				<div class="form-group">
					<label for="birthday">出生日期</label><input type="text" class="form-control" id="birthday" value="${employee.birthday}"readonly="readonly"/>
                </div>
				<div class="form-group">
					<label for="trial_start_date">试用起始日期</label><input type="text" class="form-control" id="trial_start_date" value="${employee.trial_start_time}" readonly="readonly"/>
				</div>
				<div class="form-group">
					<label for="trial_end_date">试用截止日期</label><input type="text" class="form-control" id="trial_end_date" value="${employee.trial_end_time}" readonly="readonly"/>
				</div>
				<div class="form-group">
					<label for="register_date">转正日期</label><input type="text" class="form-control" id="register_date" value="${employee.register_date}" readonly="readonly"/>
				</div>
				<div class="form-group">
					<label for="dimission_date">离职日期</label><input type="text" class="form-control" id="dimission_date" value="${employee.dimission_date}" readonly="readonly"/>
				</div>
			</form>
		</div>
	</div>
</div>

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="../js/jquery.min.js"></script>
    <script>window.jQuery || document.write('<script src="../assets/js/vendor/jquery.min.js"><\/script>')</script>
    <script src="../js/bootstrap.min.js"></script>
    <!-- Just to make our placeholder images work. Don't actually copy the next line! -->
    <script src="../assets/js/vendor/holder.min.js"></script>
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="../assets/js/ie10-viewport-bug-workaround.js"></script>
    
    
    <!--Time Picker Script-->
	<script type="text/javascript" src="../jquery/jquery-1.8.3.min.js" charset="UTF-8"></script>
	<script type="text/javascript" src="../js/bootstrap.js"></script>
	<script type="text/javascript" src="../js/bootstrap-datetimepicker.js" charset="UTF-8"></script>
	<script type="text/javascript" src="../js/bootstrap-datetimepicker.zh-CN.js" charset="UTF-8"></script>
	<script type="text/javascript">
	    $('.form_datetime').datetimepicker({
	        //language:  'fr',
	        weekStart: 1,
	        todayBtn:  1,
			autoclose: 1,
			todayHighlight: 1,
			startView: 2,
			forceParse: 0,
	        showMeridian: 1
	    });
		$('.form_date').datetimepicker({
	        language:  'fr',
	        weekStart: 1,
	        todayBtn:  1,
			autoclose: 1,
			todayHighlight: 1,
			startView: 2,
			minView: 2,
			forceParse: 0
	    });
		$('.form_time').datetimepicker({
	        language:  'fr',
	        weekStart: 1,
	        todayBtn:  1,
			autoclose: 1,
			todayHighlight: 1,
			startView: 1,
			minView: 0,
			maxView: 1,
			forceParse: 0
	    });
	</script>
	</body>
</html>
