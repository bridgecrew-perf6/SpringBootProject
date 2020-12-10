<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="login" method="post">

		<table align="center" border="1px">
			<tr>
				<td style="background-color: #b3ffff;" colspan=2><center>
						<font size=4><b>Login Page</b></font>
					</center></td>


			</tr>
			<tr>
				<td>UserName:</td>
				<td><input type="text" path="usename" name="username"
					value="${customer.username}" placeholder="Enter User Name"
					required="required"></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type="password" name="password"
					value="${customer.password}" placeholder="Enter Password"
					required="required"></td>
			</tr>
			<tr>
				<td><a href="/register-customer">register</a> <a
					href="admin-page">AdminLogin</a></td>
				<td>
					<button style="width: 100%" type="submit" class="block">Login</button>
				</td>


			</tr>
		</table>
	</form>
	<%
		String name = "username";
		session.setAttribute("username", name);
	%>

	<div>
		<label> </label>

	</div>

</body>
</html>