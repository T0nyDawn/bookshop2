<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<jsp:useBean id="book" class="com.book.dao.ProductInfoDao" scope="request"></jsp:useBean>
<!DOCTYPE html>
<html>
<head>
<meta charset="GB18030">
<title>ͼ����ϸ</title>
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
<!-- ����start -->

<table width="800px" height="400px"  border="2" cellspacing="1" align="center" class="head" >

 	<tr height="20px" bgcolor="#ffffffff">
 		<th width="100px">��Ʒ���</th>
 		<th>��ϸ���</th>
 		<th>��Ʒ����</th>
 		<th>��Ʒ�۸�</th>
 		<th>������</th>
 	</tr>
 <!-- jstl����ѭ�� -->
	<c:forEach items="${requestScope.book.bookInfoList}" var="cur_book">
	 	<tr height="20px" class="head">
	 		<td width="100px">${cur_book.prodid}</td>
	 		<td>${cur_book.itemid}</td>
	 		<td>${cur_book.prodname}</td>
	 		<td>${cur_book.prodprice}</td>
	 		<td>${cur_book.prodpress}</td>
	 		
	 	</tr>
	</c:forEach>
	<!-- <tr>
		<td width="100px" colspan="2">&nbsp;</td>
 		
	</tr> -->
 </table>
 
<!-- ����end -->
<jsp:include page="bottom.jsp"></jsp:include>
</body>
</html>