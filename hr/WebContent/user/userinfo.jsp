<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>周韬的第一个jsp文件</title>
	<%!
		int a=1,b=2;
	%>
	<%!
		//定义一个print方法
		public String print(){
		String str = "学习jsp";
		return str;
	}
	%>
</head>
<body>
	<%
		out.println(a+b);
		out.println(print());
	%>
	<br>
	<%=a+b%>
	<br>
	<%=print() %>
	<br>
	http://localhost:8080/hr/user/userinfo.jsp
	<br>
	<%
		out.println("firs line.<br>");
		response.getWriter().println("second line.<br>");
	%>
	<%
		//获取request对象
		HttpServletRequest req = (HttpServletRequest)pageContext.getRequest();
		//设置page页面的属性范围
		pageContext.setAttribute("str","Java",pageContext.PAGE_SCOPE);
		//设置request范围
		req.setAttribute("str","Java Web");
		//获取page页面属性范围
		String strPage = (String)pageContext.getAttribute("str",pageContext.PAGE_SCOPE);
		//获取request范围属性
		String strReq = (String)req.getAttribute("str");
	%>
	
	<%="page属性范围"+strPage%>
	<br>
	<%="request属性范围"+strReq %>
</body>
</html>