<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   


<jsp:useBean id="book" class="com.book.dao.ProductInfoDao" scope="request"></jsp:useBean>
<jsp:setProperty property="prodid" name="book" value="${param.prodid}"/>
<jsp:forward page="productinfo.jsp"></jsp:forward> 