<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<jsp:useBean id="book" class="com.book.dao.ProductInfoDao" scope="request"></jsp:useBean>
<!DOCTYPE html>
<html>
<head>
<meta charset="GB18030">
<title>????</title>
<style type="text/css">
		.t_bg{background-color:#8A2BE2}
		.t_right_bg{background-color:#FFF0F5}
		a:link{
			text-decoration:none;
		}
		a:visited{
			text-decoration:none;
		}
		a:active{
			text-decoration:none;
		}
		a:hover{
			text-decoration:none;
		}
		
    
		.head th{background: #ccccff;}
	</style>
</head>
<body>
<jsp:include page="title.jsp"></jsp:include>
<!-- 内容start -->

<form action="doproduct" method="post">
	<input name="a"/><input type="submit" value="OK"/>
</form>
 
<!-- 内容end -->
<jsp:include page="bottom.jsp"></jsp:include>
</body>
</html>