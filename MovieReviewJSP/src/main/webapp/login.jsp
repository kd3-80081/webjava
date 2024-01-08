<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css">
<title>Authentication Page</title>
</head>
<body>
	<jsp:useBean id="lb" class="com.sunbeam.beans.LoginBean" scope="session" />
	<jsp:setProperty name="lb" property="email" param="email" />
	<jsp:setProperty name="lb" property="password" param="password"/>
	${lb.authenticate() }
		
		
	<c:choose>
		<c:when test="${empty lb.user}">
			<br/><br/><br/>
			<p class="text-uppercase">Invalid  Email or Password</p>
			<a class="link-opacity-100" href="index.jsp">Sign In</a> 
		</c:when>
		<c:when test="${lb.status }">
			<c:redirect url="reviews.jsp?type=allreview"/>
		</c:when>
		<c:otherwise>
			<c:redirect url="index.jsp"/>
		</c:otherwise>
		
	</c:choose>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>