<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 1、获取 form表单输入的值 --> 
<jsp:useBean id="param_acc" class="com.book.entity.Account"></jsp:useBean>    
<jsp:setProperty property="*" name="param_acc"/>

<!-- 2、访问数据库，判断用户名、密码是否正确 --> 
<jsp:useBean id="loginbean" class="com.book.LoginBean" scope="session"></jsp:useBean>    
<jsp:setProperty property="param_acc" name="loginbean" value="${param_acc}"/>
<!--3、 
  if 正确 to index.jsp
  否则 to login.jsp
 --> 
<%
System.out.println("err="+loginbean.getErrCode());
if(loginbean.getReturn_acc()!=null){//用户名或密码错误  return_acc=null
%>    
  <jsp:forward page="index.jsp"></jsp:forward>
<%}else{ %>
  <%if(loginbean.getErrCode()==1){ %>
    <jsp:forward page="login.jsp">
  		<jsp:param value="1" name="b"/>
    </jsp:forward>
  <%}else{ %>
      <jsp:forward page="login.jsp">
  		<jsp:param value="1" name="c"/>
    </jsp:forward>
  <%} %>
<%} %>
<%
System.out.println("111111111111111111111111");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
  获取到的参数：用户名=${param_acc.username} ，密码=${param_acc.password}
  <hr>
  数据库对应记录的值：用户名=${loginbean.return_acc.username} ，密码=${loginbean.return_acc.password} ，中文名=${loginbean.return_acc.cnname}
</body>
</html>