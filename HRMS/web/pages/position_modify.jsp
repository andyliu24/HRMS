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
		}
		</style>
	</head>
	<body>
		<div class="container">
	<div class="row clearfix">
		<div class="col-md-12 column">
			<h3>
				岗位管理
			</h3>
			<div style="height: 1.5em;"></div>
			<ul class="nav nav-tabs">
				<li>
					 <a href="position_view.jsp">岗位查询</a>
				</li>
				<li class="active">
					 <a href="position_modify.jsp">岗位修改</a>
				</li>
				<!--<li class="disabled">
					 <a href="#">信息</a>
				</li>
				<li class="dropdown pull-right">
					 <a href="#" data-toggle="dropdown" class="dropdown-toggle">下拉<strong class="caret"></strong></a>
					<ul class="dropdown-menu">
						<li>
							 <a href="#">操作</a>
						</li>
						<li>
							 <a href="#">设置栏目</a>
						</li>
						<li>
							 <a href="#">更多设置</a>
						</li>
						<li class="divider">
						</li>
						<li>
							 <a href="#">分割线</a>
						</li>
					</ul>
				</li>-->
			</ul>
			<div style="height: 1.5em;"></div>
			<div id="tips" class="alert alert-dismissable alert-info">
				<button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
				<h4>
					注意!
				</h4>
				只有岗位编号存在才可一修改。
			</div>
			<div id="right" class="alert alert-dismissable alert-success" style="display:none" >
				<button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
				<h4>
					成功！
				</h4>
				岗位信息修改成功！
			</div>
			<div id="wrong" class="alert alert-dismissable alert-warning" style="display:none" >
				<button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
				<h4>
					失败！
				</h4>
				岗位信息修改失败，请检查岗位是否存在，再重新修改！
			</div>
			<div style="height: 0.5em;"></div>
			<form role="form" method="post" action="pos_modify">
				<div class="form-group">
					 <label for="id">岗位编号*</label>
					 <input type="text" class="form-control" id="id" name="id"/>
				</div> 
				<div class="form-group">
					 <label for="name">岗位名称*</label>
					 <input type="text" class="form-control" id="name" name="name"/>
				</div> 
				 <button type="submit" class="btn btn-default">提交</button>
			</form>
			<script>
				var status = <%=request.getAttribute("status")%>;
				if(status == 1){
				    document.getElementById("tips").style.display='none';
                    document.getElementById("right").style.display='block';
				}
				else if(status == 0){
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
