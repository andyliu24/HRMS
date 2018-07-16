<%@ page import="java.util.List" %>
<%@ page import="com.hrms.entity.Department" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

			<div id="tips" class="alert alert-info alert-dismissable" >
				<button type="button" class="close" data-dismiss="alert" >×</button>
				<h4>
					提示
				</h4>
				部门编号置空点击查询即可查看全部信息。
			</div>

			<ul class="nav nav-tabs">
				<li class="active">
					 <a href="department_view.jsp">部门查询</a>
				</li>
				<li>
					 <a href="department_modify.jsp">部门修改</a>
				</li>
			</ul>
			<div style="height: 1.5em;"></div>
			<form role="form" method="post" action="depart_serach">
				<div class="form-group">
					 <label for="id">部门编号</label>
					 <input type="number" class="form-control" id="id" name="id"/>
				</div> 
				 <button type="submit" class="btn btn-default">查询</button>
			</form>
			<div style="height: 1.5em;"></div>
			<table class="table table-hover table-bordered">
				<thead>
					<tr>
						<th>
							部门编号
						</th>
						<th>
							部门名称
						</th>
						<th>
							部门经理工号
						</th>
						<th>
							上级部门编号
						</th>
					</tr>
				</thead>
				<tbody>
						<c:forEach var="item" items="${result}">
							<tr>
							<td>
									${item.id}
							</td>

							<td>
									${item.name}
							</td>
							<td>
									${item.manager_id}
							</td>
							<td>
									${item.superior}
							</td>
							</tr>
						</c:forEach>
				</tbody>
			</table>
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
