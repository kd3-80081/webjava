<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Sign Up</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css">
</head>
<body>
	<div class="container" >
	<br>
		<h1>Movie Review App</h1>
		
		<hr>
			<h3 class="text-center" >Sign Up</h3>
		<hr>
	</div>
	
	<div class="container col-sm-3 ">
		<form method="post" action="signupresult.jsp">
			<div class="form-group">	
				<label for="firstName">First Name</label>
				<input type="text" class="form-control"  name="firstName" placeholder="Enter first name">
			</div>
			<div class="form-group">	
				<label for="lastName">Last Name</label>
				<input type="text" class="form-control"  name="lastName"  placeholder="Enter last name">
			</div>
			<div class="form-group">	
				<label for="email">Email address</label>
				<input type="text" class="form-control"  name="email" placeholder="Enter email">
			</div>
			<div class="form-group">	
				<label for="form">Password</label>
				<input type="password" class="form-control"  name="password"  placeholder="Enter password">
			</div>
			<div class="form-group">	
				<label for="mobileNo">Mobile No</label>
				<input type="number" class="form-control"  name="mobileNo"  placeholder="Enter mobile number">
			</div>
			<div class="form-group">	
				<label for="dob">Birth date</label>
				<input type="date" class="form-control"  name="dob"  >
			</div>
			<br>
			 <div > <button type="submit" class="btn btn-primary">Submit</button> <label class="text-justify">Already have account?</label> <a class="link-opacity-100" href="index.jsp">Sign In</a> </div>  
		</form>
	</div>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>