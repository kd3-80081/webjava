<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Player Result</title>
</head>
<body>
<jsp:useBean id="pb" class="beans.PlayerBean" scope="session" />
<jsp:setProperty property="*" name="pb"/>
	<br> <br>
${pb.addPlayer() }
</body>
</html>