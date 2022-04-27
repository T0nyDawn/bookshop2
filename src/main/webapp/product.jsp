<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
	</style>
</head>
<body>
<jsp:include page="title.jsp"></jsp:include>

<table width="800px" height="400px" align="center" border="2"  bgcolor="#d4e0ec">
 	<tr height="20px">
 		<th width="100px">商品编号</th>
 		<th>商品名称</th>
 		<th>详情</th>
 	</tr>
 <!-- jstl进行循环 -->
	<c:forEach items="${requestScope.book.bookList}" var="cur_book">
	 	<tr height="20px">
	 		<td width="100px">${cur_book.prodid}</td>
	 		<td>${cur_book.prodname}</td>
	 		<td><a href="doproductinfo.jsp?prodid=${cur_book.prodid}">详情</a></td>
	 	</tr>
	</c:forEach>
	<!-- <tr>
		<td width="100px" colspan="2">&nbsp;</td>
 		
	</tr> -->
 </table>
 
<!-- 内容end -->
<jsp:include page="bottom.jsp"></jsp:include>
</body>
</html>