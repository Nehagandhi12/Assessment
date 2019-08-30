<!-- If the user tries to update address without getting permissions then it UserController redirects to this page -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta charset="ISO-8859-1">
</head>
<link rel="stylesheet" type="text/css" href="Property.css" />
</head>
<body class="center">

	<form action="user.jsp">
		<h3>
			Update Permissions will only be given to you,when you complete 100
			days after being added by admin.<br> <br> If you have
			logged in for the first time ,change your password first or else you
			won't be allowed to update address
		</h3>
		<input type="submit" class="submit" value="Back">
	</form>
</body>
</html>