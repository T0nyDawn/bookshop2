<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<c:forTokens items="${param.n}" delims="," var="v">
	${v}<br/>
</c:forTokens>
<hr>
**************************<br/>
<c:if test="${param.x>10}">
  abcd-x>10<br/>
</c:if><br/>
**************************<br/>
<c:choose>
	<c:when test="${param.x>10}">
		x>10
	</c:when>
	<c:when test="${param.x<10}">
		x<10
	</c:when>
	<c:otherwise>
	    x=10
	</c:otherwise>
</c:choose><br/>
**************************<br/>
<hr>
<jsp:useBean id="accDao" class="com.book.dao.AccountDaoImpl"></jsp:useBean>

<table width="800px" border="1">
	<tr>
		<th width="60px">序号</th>
		<th width="80px">用户名</th>
		<th width="100px">中文名</th>
		<th>城市</th>
	</tr>
<c:forEach items="${accDao.allAccounts}" var="cur_acc">	
	<tr>
		<td>1</td>
		<td> ${cur_acc.username}</td>
		<td>${cur_acc.cnname}</td>
		<td>${cur_acc.city}</td>
	</tr>	
</c:forEach>	
</table>
<hr/>
<c:forEach items="${accDao.allAccounts}" var="cur_acc">
  ${cur_acc.username},${cur_acc.cnname}<br/>
</c:forEach>
<hr/>
<c:set var="x" value="1"></c:set>

<c:set var="sum" value="0"></c:set>
<c:set var="v" value="1"></c:set>
<c:forEach var="i" begin="1"  end="100" step="1">
  <c:if test="${i%4==0}">
	 <c:set var="sum" value="${sum+i}"></c:set>
  </c:if>
</c:forEach>
1+2+3+...+100=${sum}<br/>
<c:set var="x" value="${x+1}"></c:set>
<c:out value="${x}"></c:out><br/>
${x}
<hr>
<c:out value="123"></c:out>
${123}
</body>
</html>