<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
//if("1".equalsIgnoreCase(request.getParameter("a")))
if(request.getParameter("a")!=null )
{	
%>
	<font color="red">首页，必须先登录，后访问！</font>
<%
} 
%>

<%
if(request.getParameter("b")!=null)
{
%>
	<font color="red">用户名错误！</font>
<%
}
%>	


<%
if(request.getParameter("c")!=null)
{
%>
	<font color="red">密码错误！</font>
<%
}
%>		
	
	<form action="login" method="post">
	<!-- post方法可以传递中文，get方法无法传 -->
		用户名：<input name="username"/><br/>
		密码：<input name="password"/><br/>
		<input type="submit"  value="登录" />
	</form>
</body>
</html>