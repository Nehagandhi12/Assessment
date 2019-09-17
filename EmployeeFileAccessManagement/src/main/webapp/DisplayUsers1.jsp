<!-- This page displays the list of users to manager -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="Property.css" />
</head>
<body class="center">
	<h2>The following is the list of Users</h2>
	<table>
		<%
			List<String> list = (List<String>) request.getSession().getAttribute("managerlistofusers");
		%>
		<%
			for (String b : list) {
		%>
		<tr>
			<td><%=b%></td>

			<%
				}
			%>
		
	</table>
	<form action="manager.jsp">
		<input type="submit" value="Back" class="submit" />
	</form>
</body>
</html>
