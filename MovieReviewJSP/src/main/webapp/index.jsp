<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Login</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css">
</head>
<body>
	<div class="container" >
	<br>
		<h1>Movie Review App</h1>
		
		<hr>
		<h3 class="text-center" >Sign In</h3>
		
		<hr>
	</div>
	
	
	<div class="container col-sm-3 ">
	
		<br>
		<form method="post" action="login.jsp">
			<div class="form-group">	
				<label for="email">Email address</label>
				<input type="text" class="form-control"  name="email" placeholder="Enter email">
			</div>
			<div class="form-group">	
				<label for="form">Password</label>
				<input type="password" class="form-control"  name="password"  placeholder="Enter password">
			</div>
			<br>
			 <div > <button type="submit" class="btn btn-primary">Submit</button> <label class="text-justify">Don't have account?</label></label>  <a class="link-opacity-100" href="signup.jsp">Sign Up</a> </div>  
		</form>
	</div>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>