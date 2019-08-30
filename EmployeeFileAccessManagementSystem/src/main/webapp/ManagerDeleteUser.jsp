<!-- Gets the details from the manager about the  userid to be deleted -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta charset="ISO-8859-1">
</head>
<link rel="stylesheet" type="text/css" href="Property.css" />
<script>
	function changeaddress() {
		var address = document.form.userid.value;
		if (address == null || address == "") {
			alert("Id Field cannot be blank");
			return false;
		} 
	}
</script>
</head>
<body class="center">
	<form action="managerlogin/deleteuser" name="form"
		onsubmit="return changeaddress();" method="post">
		<label>Enter UserId To delete*</label> <INPUT type="text"
			name="userid" size="30px"> <br>
		<br> <input type="submit" class="submit" value="Delete User">&nbsp;&nbsp;
		<input type="reset" class="submit" value="Reset"> <br /> <br />
	</form>
	<form action="manager.jsp">
		<input type="submit" value="Go Back" class="submit" class="center">
	</form>
</body>
</html>