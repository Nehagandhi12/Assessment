<!-- Gets the details from the admin about the new user -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="Property.css" />
<script>
	function validLogin() {
		var userid = document.form.userid.value;
		var username = document.form.username.value;
		var address = document.form.address.value;
		if (userid == null || userid == "") {
			alert("UserId cannot be blank");
			return false;
		} else if (username == null || username == "") {
			alert("Password cannot be blank");
			return false;
		} else if (address == null || address == "") {
			alert("Address cannot be blank");
			return false;
		}
	}
</script>
</head>

<body class="center">
	<h3>
		<b>Enter the required details of user</b>
	</h3>
	<form action="login/adduser" method="post" name="form"
		onsubmit="return validLogin();">
		<table class="center">
			<tr>
				<td><label>Enter UserId</label></td>
				<td><input type="text" name="userid"></td>
			</tr>
			<tr>
				<td><label>Enter Username</label></td>
				<td><input type="text" name="username"></td>
			</tr>
			<tr>
				<td><label>Enter Address</label></td>
				<td><input type="text" name="address"></td>
			</tr>
		</table>
		<input type="submit" value="Submit the details" name="button1"
			class="submit">

	</form>
</body>
</html>