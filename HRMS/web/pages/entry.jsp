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
				.alert-warning{
					width: 42%;
				}
				.alert-success{
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
				员工入职
			</h3>
			<div style="height: 2em;"></div>
			<div id="right" class="alert alert-success alert-dismissable" style="display: none">
				<button type="button" class="close" data-dismiss="alert" >×</button>
				<h4>
					成功！
				</h4>
				员工入职信息已被成功添加！
			</div>

			<div id="wrong" class="alert alert-warning alert-dismissable" style="display: none">
				<button type="button" class="close" data-dismiss="alert" >×</button>
				<h4>
					失败
				</h4>
				遇到了一些问题，请核实部门编号和岗位编号是否存在！
			</div>



			<form role="form" method="post" action="entry">
				<div class="form-group">
					 <label for="id">员工编号*</label><input type="number" class="form-control" name="id" required="required" size="15" oninput="if(value.length>20)value=value.slice(0,20)"/>
				</div>
				<div class="form-group">
					 <label for="department_id">部门编号*</label><input type="number" class="form-control" name="department_id" required="required" oninput="if(value.length>20)value=value.slice(0,20)"/>
				</div>
				<div class="form-group">
					 <label for="position_id">岗位编号*</label><input type="number" class="form-control" name="position_id" required="required" oninput="if(value.length>20)value=value.slice(0,20)"/>
				</div>
				<div class="form-group">
					 <label for="name">姓名*</label><input type="text" class="form-control" name="name" required="required" maxlength="5"/>
				</div>
				<div class="form-group">
					 <label for="gender">性别*</label><br/>
					 <input type="radio" name="gender" value="男" checked="checked"/>男
					 &nbsp;
 					 <input type="radio" name="gender" value="女"/>女
				</div><p/>
				<div class="form-group">
					 <label for="telephone">电话*</label><input type="number" class="form-control" name="telephone" required="required" oninput="if(value.length>11)value=value.slice(0,11)"/>
				</div>
				<div class="form-group">
					 <label for="salary">月薪*</label><input type="number" class="form-control" name="salary" required="required" oninput="if(value.length>11)value=value.slice(0,11)"/>
				</div>
				<div class="form-group">
					<label for="birthday">出生日期*</label>
				 	<div class="input-group date form_date col-md-5" data-date="" data-date-format="dd MM yyyy" data-link-field="dtp_input2" data-link-format="yyyy-mm-dd">
					<input class="form-control" size="16" type="text" value="" name="birthday" required="required" readonly="readonly">
					<span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
                </div><p/>
            		<div style="height: 2em;"></div>
			   <button type="submit" class="btn btn-default">提交</button>&nbsp;&nbsp;
			   <button type="reset" class="btn btn-default">重置</button>
			</form>
			<script>
                var status = <%=request.getAttribute("status")%>;

                if (status == 1){
                    document.getElementById("right").style.display="block";
                } else if (status == 0){
                    document.getElementById("wrong").style.display="block";
                }
			</script>
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
