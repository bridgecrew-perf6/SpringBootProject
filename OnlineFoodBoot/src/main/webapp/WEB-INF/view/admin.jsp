<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="admin-verify" method="post">
		<table align="center" border="1px">
			<tr>
				<td colspan=2><center>
						<font size=4><b>Admin Page</b></font>
					</center></td>
			</tr>
			<tr>
				<td>Admin:</td>
				<td><input type="text" name="admin" value="${user.admin}"
					placeholder="Enter Admin" required="required"></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type="password" name="password"
					value="${user.password}" placeholder="Enter Password"
					required="required"></td>
			</tr>
			<tr>
			<td colspan="3">
				<button style="width: 100%" type="submit"  >AdminLogin</button>
			</td>
				

			</tr>
		</table>
	</form>

</body>
</html>