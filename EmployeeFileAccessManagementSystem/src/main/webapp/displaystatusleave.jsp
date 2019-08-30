<!-- This page displays leavestatus applied by logged in manager -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="Property.css" />
</head>
<body class="center">
	<%String status=(String)request.getSession().getAttribute("status");
%>
	<h2>YOUR LEAVE STATUS</h2><%=status %>
	<br>
	<br>
	<form action="manager.jsp">
		<input type="submit" value="GO BACK" class="submit">
	</form>
</body>
</html>