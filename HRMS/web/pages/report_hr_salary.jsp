<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
	<head>
		<meta charset="UTF-8">
		<title>主界面</title>
			
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
	    
	    <!--饼状图所需文件-->
	      <link href="../css/dmaku.css" rel="stylesheet"/>  
		  <script src="../js/jquery-1.11.1.min.js"></script> 
		  <script src="../js/echarts-all.js" type="text/javascript"></script> 
		  
	</head>
	<body>
	<div class="container">
	<div class="row clearfix">
		<div class="col-md-12 column">
			<div style="height: 2em;"></div>
			<h3>
				人事薪资报表
			</h3>
   <center> 
   <!--饼形图--> 
   <div class="echarts_pie"> 
    <div class="content"> 
     <div id="echart" _echarts_instance_="1489833121462" style="-webkit-tap-highlight-color: transparent; -webkit-user-select: none; cursor: default; background-color: rgba(0, 0, 0, 0);">
      <div style="position: relative; overflow: hidden; width: 1000px; height: 538px;">
       <div data-zr-dom-id="bg" class="zr-element" style="position: absolute; left: 0px; top: 0px; width: 1000px; height: 538px; -webkit-user-select: none;"></div>
       <canvas width="1000" height="538" data-zr-dom-id="0" class="zr-element" style="position: absolute; left: 0px; top: 0px; width: 1000px; height: 538px; -webkit-user-select: none; -webkit-tap-highlight-color: rgba(0, 0, 0, 0);"></canvas>
       <canvas width="1000" height="538" data-zr-dom-id="_zrender_hover_" class="zr-element" style="position: absolute; left: 0px; top: 0px; width: 1000px; height: 538px; -webkit-user-select: none; -webkit-tap-highlight-color: rgba(0, 0, 0, 0);"></canvas>
      </div>
     </div> 
    </div> 
   </div> 
   <script>
		var myChart = echarts.init(document.getElementById('echart'));
		option = {
		    legend: {
		        orient : 'vertical',
		        x : 'left',
		        data:[]
		    }, 
		  	color:['#4A5873','#F76666','#16CF45','#119FD9','#E5D117','#FF7C41', '#FF5151'],
		    
		    calculable : false,
		    series : [
		        {
		            name:'',
		            type:'pie',
		            selectedMode: 'single',
		            radius : [0, 90],
		            // for funnel
		            x: '20%',
		            width: '40%',
					y: '90%',
		            funnelAlign: 'right',
		            max: 1548,
		            
		            itemStyle : {
		                normal : {
		                    label : {
		                        position : 'inner',
		                    },
		                    labelLine : {
		                        show : false
		                    }
		                }
		            },
		            data:[
		                {value:335, name:'薪资范围\n\n\n'}
		            ]
		        },
		        {
		            name:'',
		            type:'pie',
		            radius : [100, 200],
		            
		            // for funnel
		            x: '80%', 
		            width: '70%',
		            funnelAlign: 'left',
		            max: 1048,
		            itemStyle : {
		                normal : {
		                    label : {
		                        position : 'inner'
		                    },
		                    labelLine : {
		                        show : false
		                    }
		                }
		            },
		            data:[
		                { value:500, name:'500~1000'},
						{ value:500,name:'1000~5000'},
						{ value:500, name:'5000~10000'},
						{ value:500, name:'10000+'},
		            ]
		        }
		    ]
		};
		
		// 为echarts对象加载数据 
		myChart.setOption(option);
	</script> 
  </center> 
  
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
