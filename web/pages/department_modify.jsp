<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
	<head>
		<meta charset="UTF-8">
		<title>部门信息</title>
			
	    <!-- Bootstrap core CSS -->
	    <link href="../css/bootstrap.min.css" rel="stylesheet">
	
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
    		<style>
		@media screen and (min-width:990px) {
			.form-control{
			width: 42%;
			}
			.alert-info{
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
				部门管理
			</h3>
			<div style="height: 1.5em;"></div>
			<ul class="nav nav-tabs">
				<li>
					 <a href="department_view.jsp">部门查询</a>
				</li>
				<li class="active">
					 <a href="department_modify.jsp">部门修改</a>
				</li>
			</ul>
			<div style="height: 1.5em;"></div>
			<div id="tips" class="alert alert-dismissable alert-info">
				<button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
				<h4>
					注意!
				</h4>
				只需要填写修改的信息，不作修改的项目留空即可！
			</div>
			<div id="right" class="alert alert-dismissable alert-success" style="display:none" >
				<button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
				<h4>
					成功！
				</h4>
				部门信息修改成功！
			</div>
			<div id="wrong" class="alert alert-dismissable alert-warning" style="display:none" >
				<button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
				<h4>
					失败！
				</h4>
				部门信息修改失败，请检查部门是否存在或部门经理是否存在，再重新修改！
			</div>
			<form role="form" method="post" action="depart_modify">
				<div class="form-group">
					 <label for="id">部门编号*</label>
					 <input type="text" class="form-control" id="id" required="required" name="id" />
				</div> 
				<div class="form-group">
					 <label for="name">部门名称</label>
					 <input type="text" class="form-control" id="name" name="name" />
				</div> 
				<div class="form-group">
					 <label for="manager_ID">部门经理工号</label>
					 <input type="number" class="form-control" id="manager_ID" name="manager_id" />
				</div> 
				<div class="form-group">
					 <label for="superior">上级部门编号</label>
					 <input type="number" class="form-control" id="superior" name="superior" />
				</div> 

				 <button type="submit" class="btn btn-default">提交</button>

			</form>
			<script>
				var status = <%=request.getAttribute("status")%>

				if(status == 1){
				    document.getElementById("tips").style.display='none';
				    document.getElementById("right").style.display='block';
				}else if(status == 0){
                    document.getElementById("tips").style.display='none';
                    document.getElementById("wrong").style.display='block';
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
    
	</body>
</html>
