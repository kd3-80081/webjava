<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css">
<title>Sign Up Result</title>
</head>
<body>
	<jsp:useBean id="sb" class="com.sunbeam.beans.SignUpBean" />
	<jsp:setProperty property="*" name="sb"/>
	${sb.signup()}
	
	<c:choose>
		<c:when test="${sb.count eq 1 }">
			<br/><br/><br/>
			<p class="text-uppercase">Signed Up successfully!!!</p>
			<a class="link-opacity-100" href="index.jsp">Sign in</a> 
		</c:when>
		<c:otherwise>
			<br/><br/><br/>
			<p class="text-uppercase ">Something went wrong... Please try again!!!</p>
		</c:otherwise>
	</c:choose>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>