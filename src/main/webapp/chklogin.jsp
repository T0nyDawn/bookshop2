<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 1.获取form表单输入的值 -->

<jsp:useBean id ="param_acc" class=com.book.dao.Account"></jsp:useBean>
<jsp:setProperty property="*" name="param_acc"/>
<!-- 2.访问数据库，判断用户名和密码是否正确 -->
<jsp:useBean id ="loginbean" class=com.book.LoginBean"></jsp:useBean>
<jsp:setProperty property="param_acc" name="loginbean" value="${param_acc} "/>
<!-- 3.
	if true to index.jsp
	or to login.jsp
	 -->
<jsp:forward page="login.jsp"></jsp:forward>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	获取到用户名=${param_acc.username}，密码=${param_acc.password}
	<hr>
	获取到用户名=${loginbean.return_acc.username}，密码=${loginbean.return_acc.password}
</body>
</html>

