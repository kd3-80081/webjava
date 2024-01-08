<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Log Out</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css">
</head>
<body>
	<%session.invalidate(); %>
	<br>
	<br>
	<div class="container">
	<p class="text-uppercase">Thank You for visiting!!!</p>
	<br>
	<a class="link-opacity-100" href="index.jsp">Sign In</a>
	</div>
	

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>