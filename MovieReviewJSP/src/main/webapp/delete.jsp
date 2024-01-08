<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css">
<title>DeleteReview</title>
</head>
<body>
	<jsp:useBean id="db" class="com.sunbeam.beans.DeleteBean" />
	<jsp:setProperty name="db" property="reviewId" param="reviewId" />
	<jsp:setProperty name="db" property="url" param="url" />


	<c:choose>
		<c:when test=" ${empty lb.user}">
			<br />
			<br />
			<br />
			<p class="text-uppercase">Please Login In first!!!</p>
			<a class="link-opacity-100" href="index.jsp">Sign in</a>
		</c:when>
		<c:when test="${lb.status}">
			${db.delete()}	
			 <c:choose>
				<c:when test="${db.url == allreviews}">
					<c:redirect url="reviews.jsp?type=allreview" />
				</c:when>
				<c:when test="${db.url == myreviews}">
					<c:redirect url="reviews.jsp?type=myReviews" />
				</c:when>
				<c:when test="${db.url == sharedreviews}">
					<c:redirect url="reviews.jsp?type=sharedReviews" />
				</c:when>


			</c:choose>
		</c:when>

		<c:otherwise>
			<br>
			<br>
			<br>
			<p class="text-uppercase text-center ">Something went wrong...
				Please try again!!!</p>
			<a class="link-opacity-100 " href="reviews.jsp?type=allreview">All
				Reviews</a>

		</c:otherwise>
	</c:choose>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>