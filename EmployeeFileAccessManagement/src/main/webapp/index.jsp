<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta charset="ISO-8859-1">
</head>
<link rel="stylesheet" type="text/css" href="Property.css" />
<script>
	function validLogin() {
		var username = document.form.id.value;
		var password = document.form.password.value;
		if (username == null || username == "") {
			alert("Username cannot be blank");
			return false;
		} else if (password == null || password == "") {
			alert("Password cannot be blank");
			return false;
		}
	}
</script>
</head>
<body class="center">
	<marquee>
		<i><h1>ComakeIT</h1></i>
	</marquee>
	<h2 class="center">
		<u>Employee File Management System</u>
	</h2>
	<form action="login/validate" method="post" name="form"
		onsubmit="return validLogin();">
		<b style="color: black">Login Here-----></b><br>
		<table class="center">
			<tr>
				<td><b>Id</b></td>
				<td><input type="text" name="id" size="20px"></td>
			</tr>
			<tr>
				<td><b>Password</b></td>
				<td><INPUT type="password" name="password" size="20px"></td>
			</tr>
			<tr>
				<td><input type="submit" class="submit" value="Login"></td>
				<td><input type="reset" class="submit" value="Reset"></td>
		</table>
		<br /> <br /> <font color="red"><%=(request.getSession().getAttribute("errormsg") == null) ? ""
					: request.getSession().getAttribute("errormsg")%></font>
	</form>
</body>
</html>