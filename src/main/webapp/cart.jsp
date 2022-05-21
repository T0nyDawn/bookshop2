<%@page import="java.util.*"%>
<%@page import="com.book.entity.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
   
    .nr{
    	height:400px;
    	width:100%;
    	text-align: center;
    }
    .tab{
       border-collapse:collapse;
       width:800px;
       
    }
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
${requestScope.errMsg}
<%-- <%
//out.println("["+request.getAttribute("errMsg")+"]");
Object o=session.getAttribute("cart");
List<CardItem> cart=(List<CardItem>)o;
int i=0;
int cs=cart.size();
while(i<cs){
	CardItem cur=cart.get(i);
	
	out.println(cur.getProductid());
	out.println(cur.getProduct().getProdname());
	out.println(cur.getSl());
	out.println("<br/>");
	i++;
}
%> --%>

<div  class="nr" >
<form action="">
<table  align="center" class="tab" border="2";>
	<tr height="20px">
		<th width="100px">商品编号</th>
		<th>商品名称</th>
		<th>数量</th>
	</tr>
	<c:forEach items="${sessionScope.cart}" var="cur">
	  <tr height="20px">
		<td width="100px">${cur.productid}</td> 
		<td>${cur.product.prodname}</td>
		<td><input name="sl_${cur.productid}" value="${cur.sl}"> </td>
	  </tr>
	</c:forEach>
<!-- 空白行 删除了 -->
</table>
</form>
</div>
</body>
</html>