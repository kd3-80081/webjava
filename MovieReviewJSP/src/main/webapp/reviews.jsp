<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="m" uri="/WEB-INF/moviereview.tld" %>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html>
<html>
<head>
<title>Reviews</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css">
</head>
<body>
	
	<jsp:useBean id="rb" class="com.sunbeam.beans.ReviewsBean"/>
	${rb.reviews() }

	<div class="container">
		<br>
		<h1>Movie Review App</h1>

		<hr>
		<h3 class="text-center">Reviews</h3>

		<hr>
		<a class="link-opacity-100" href="reviews.jsp?type=allreview">All Reviews</a> | <a
			class="link-opacity-100" href="reviews.jsp?type=myReviews">My Reviews</a> | <a
			class="link-opacity-100" href="reviews.jsp?type=sharedReviews">Shared Reviews</a>
		| <a class="text-right" href="logOut.jsp">Log Out</a>
		<hr>
		<table class="table table-striped">
			<thead>
				<tr>
					<th scope="col">Review Id</th>
					<th scope="col">Movie</th>
					<th scope="col">Review</th>
					<th scope="col">Rating</th>
					<th scope="col">User Id</th>
					<th scope="col">Modified</th>
					<th scope="col">Action</th>
					
				</tr>
			</thead>
			<tbody>
			
			<c:forEach var="l" items="${rb.list}">
				<tr>
					<th scope="row">${l.reviewId }</th>
					<td><m:movie movieId="${l.movieId }"/> </td>
					<td>${l.review }</td>
					<td>${l.rating }</td>
					<td>${l.userId}</td>
					<td>${l.modified }</td>
					<td><a href="delete.jsp?reviewId=${l.reviewId }&url=allreviews"  type="button" class="btn btn-danger" >Delete</a> </td>
					
				</tr>
			</c:forEach>
				
			
			</tbody>
		</table>


	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>