<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
	function myFunction() {

		var user = document.getElementById("uname").value;
		var pass = document.getElementById("pwd").value;
		if (user == "" || user == null) {
			alert("please enter username");
			return false;
		}
		if (pass == "" || pass == null) {
			alert("please enter password");
			return false;
		}
	}
</script>

<style type="text/css">
.cls {
	background-color: gray;
}
</style>
</head>
<body class="cls">
	<form action="Validate" method="post" onsubmit="return myFunction()">
		<table align="center">
			<tr>
				<td>Username</td>
				<td><input type="text" name="uname" id="uname" /></td>
			</tr>

			<tr>
				<td>password</td>
				<td><input type="password" name="pwd" id="pwd" /></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" /></td>
			</tr>
		</table>
	</form>


	<p align="center"><a href="Newuser.jsp" style="float: ce">Signup</a></p>
</body>
</html>