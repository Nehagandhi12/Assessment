<!-- Here the user enters new password to be updated -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta charset="ISO-8859-1">
</head>
<link rel="stylesheet" type="text/css" href="Property.css" />
<script>
	function changeaddress() {
		var address = document.form.userpassword.value;
		if (address == null || address == "") {
			alert("Password Field cannot be blank");
			return false;
		} 
	}
</script>
</head>
<body class="center">
	<form action="login/changepassword" name="form"
		onsubmit="return changeaddress();">
		<label>Enter password to change*</label> <INPUT type="password"
			name="userpassword" size="30px"> <br>
		<br> <input type="submit" class="submit" value="Update Password">&nbsp;&nbsp;
		<input type="reset" class="submit" value="Reset"> <br /> <br />
	</form>
	<form action="user.jsp">
		<input type="submit" value="Go Back" class="submit" class="center">
	</form>
</body>
</html>