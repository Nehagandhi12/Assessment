<!-- The page gets the new address to be updated from the user-->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta charset="ISO-8859-1">
</head>
<link rel="stylesheet" type="text/css" href="Property.css" />
<script>
	function changeaddress() {
		var address = document.form.address.value;
		if (address == null || address == "") {
			alert("Address Field cannot be blank");
			return false;
		} 
	}
</script>
</head>
<body class="center">
	<form action="login/changeaddress" name="form"
		onsubmit="return changeaddress();">
		<label>Enter address to update*</label> <INPUT type="text"
			name="address" size="30px"> <br>
		<br> <input type="submit" class="submit" value="Update Address">&nbsp;&nbsp;
		<input type="reset" class="submit" value="Reset"> <br /> <br />
	</form>
	<form action="user.jsp">
		<input type="submit" value="Go Back" class="submit" class="center">
	</form>
</body>
</html>