<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
//request.getParameter("lb");
%>
<jsp:useBean id="book" class="com.book.dao.ProductDao" scope="request"></jsp:useBean>
<jsp:setProperty property="lb" name="book" value="${param.lb}"/>
<jsp:forward page="product.jsp"></jsp:forward>
