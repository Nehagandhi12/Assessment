<!-- Displays the list of admin or managers who have requested to the logged in manager for a leave -->
<%@page import="java.util.ArrayList"%>
<%@page import="com.example.Bean.LeaveBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body style="background-color: #E7BE77">
	<table border="2" style="border: 2px solid black; width: 100%">
		<a href="/manager.jsp">Go Back</a>
		<%
			ArrayList<LeaveBean> hash = (ArrayList<LeaveBean>) request.getAttribute("object");
		%>
		<%
			for (LeaveBean b : hash) {
		%>
		<tr>
			<td><%=b.getLeaveid()%></td>
			<td><%=b.getEmpid()%></td>
			<td><%=b.getStartdate()%></td>
			<td><%=b.getReason()%></td>
			<td><%=b.getNumberofdays()%></td>
			<td><%=b.getStatus()%></td>
			<td><a href=acceptleave?status=accept&id=<%=b.getLeaveid()%>>>accept</a></td>
			<td><a href=rejectleave?status=reject&id=<%=b.getLeaveid()%>>>reject</a></td>
		</tr>
		<%
			}
		%>
	</table>
</body>
</html>