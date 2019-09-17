<!-- This page is the leave form to be filled by manager  -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function validLogin() {
		var reason = document.form.reason.value;
		var startdate = document.form.startdate.value;
		var numberofdays = document.form.numberofdays.value;
		if (reason == null || reason == "") {
			alert("Reason cannot be blank");
			return false;
		} else if (startdate == null || startdate == "") {
			alert("StartDate cannot be blank");
			return false;
		} else if (numberofdays == null || numberofdays == "") {
			alert("Number Of Days cannot be blank");
			return false;
		}
	}
</script>
</head>
<link rel="stylesheet" type="text/css" href="Property.css" />
<body>
	<form action="managerlogin/applyleave" method="post">
		<h3 align="center">
			<u>Apply For Leave</u>
		</h3>
		<br>
		<hr style="border: 1px solid black;">
		<br>
		<div class="center" align="center"
			style="border: 2px solid black; width: 400px; height: 200px;">
			<label>Reason</label> <select name="reason">
				<option value="vacation">Vacation</option>
				<option value="sick">Sick</option>
				<option value="casual">Casual</option>
			</select><br>
			<hr style="border: 1px solid black;">
			<label>Start Date</label> <input type="date" name="startdate"
				placeholder="yyyy-mm-dd" /><br>
			<hr style="border: 1px solid black;">
			<label>Number Of Days</label> <input type="text" name="numberofdays" /><br>
			<hr style="border: 1px solid black;">
			<input type="submit" value="Submit" name="button1" class="submit" />&nbsp;&nbsp;
		</div>
	</form>
	</div>
</body>
</html>