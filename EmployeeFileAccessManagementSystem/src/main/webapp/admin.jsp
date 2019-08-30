
<!-- This page gives a view of different functionalities available to the admin -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<html>
<head>
<link rel="stylesheet" type="text/css" href="Property.css" />
<meta charset="ISO-8859-1">
</head>

<body class="center">
	<h1>Welcome Admin!!!</h1>

	<a href="AddUser.jsp">ADD USER</a>
	<br>
	<br>
	<a href="DeleteUser.jsp">DELETE USER</a>
	<br>
	<br>
	<a href="login/displaylist">DISPLAY LIST OF USERS IN SORTED ORDER</a>
	<br>
	<br>
	<a href="login/grantpermission">GRANT PERMISSION TO USERS</a>
	<br>
	<br>
	<a href="leaveform.jsp">APPLY LEAVE</a>
	<br>
	<br>
	<a href="login/checkstatusleave">CHECK LEAVE STATUS</a>
	<br>
	<br>
	<form action="index.jsp">
		<input type="submit" value="Logout" class="submit" class="center">
	</form>
</body>
</html>
