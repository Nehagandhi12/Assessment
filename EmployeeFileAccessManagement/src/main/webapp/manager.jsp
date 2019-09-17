<!-- This page shows the different functionalities that can be performed by a manager -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="Property.css" />
</head>
<body class="center">
	<h1>Welcome Manager!!!</h1>
	<a href="form.jsp">APPLY FOR LEAVE</a>
	<br>
	<br>
	<a href="ManagerAddUser.jsp">ADD USER</a>
	<br>
	<br>
	<a href="ManagerDeleteUser.jsp">DELETE USER</a>
	<br>
	<br>
	<a href="managerlogin/displaylist">DISPLAY LIST OF USERS IN SORTED
		ORDER</a>
	<br>
	<br>
	<a href="managerlogin/grantpermission">GRANT PERMISSION TO USERS</a>
	<br>
	<br>
	<a href="managerlogin/grantleave">GRANT LEAVE</a>
	<br>
	<br>
	<a href="managerlogin/checkstatusleave">CHECK LEAVE STATUS</a>
	<br>
	<br>
	<form action="index.jsp">
		<input type="submit" value="Logout" class="submit">
	</form>
</body>
</html>
