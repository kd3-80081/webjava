<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Player</title>
</head>
	<jsp:useBean id="tb" class="beans.TeamBean" scope="session" />
	
	
	
	
<body>
${pd.addPlayer }
	<form action="process_form.jsp" method="post">
		<table style="background-color: lightgrey; margin: auto">
			<tr>
				<td>Select Team</td>
				<td><select name="myTeam">
						<option value="0">Select</option>
						<c:forEach var="list" items="${sessionScope.tb.displayTeamAbbreviation() }">
							<option value="${list.id }">${list.abbreviation }</option>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td>Enter First Name</td>
				<td><input type="text" name="firstName" required  /></td>
			</tr>
			<tr>
				<td>Enter Last Name</td>
				<td><input type="text" name="lastName" required /></td>
			</tr>
			<tr>
				<td>Select DoB</td>
				
				<td><input type="date" name="dob" /></td>
			</tr>
			<tr>
				<td>Enter Batting Average</td>
				<td><input type="number" value="0.00" step="0.10" name="battingAvg" /></td>
			</tr>
			<tr>
				<td>Enter No Of Wickets Taken</td>
				<td><input type="number" name="wicketsTaken" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Add A Player" /></td>
			</tr>
		</table>
	</form>
	
</body>


</html>