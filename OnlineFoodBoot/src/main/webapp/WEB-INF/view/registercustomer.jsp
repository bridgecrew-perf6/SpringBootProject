<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="register">
<a href="/login-customer">back</a><br><br>

		<table  border="1px">
		<input type="hidden" name="cno" value="${customer.cno }">
		<tr>
				<td colspan=2><center>
						<font size=4><b>Register Customer</b></font>
					</center></td>
			</tr>
			<tr>
				<td>UserName:</td>
				<td><input type="text" name="username" value="${customer.username}"
					required="required"></td>
			</tr>
			<tr>
				<td>FirstName:</td>
				<td><input type="text" name="firstname"
					value="${customer.firstname}" required="required"></td>
			</tr>
			<tr>
				<td>LastName:</td>

				<td><input type="text" name="lastname" value="${customer.lastname}"
					required="required"></td>
			</tr>
			
			
			<tr>
				<td>MobileNumber:</td>

				<td><input type="text" name="mobileno" value="${customer.mobileno}"
					required="required"></td>
			</tr>
			<tr>
				<td>Password:</td>

				<td><input type="password" name="password"
					value="${customer.password}" required="required"></td>
			</tr>
			<tr>
			

				<td colspan = "3">
					<button style="width: 100%"type="submit" >Register</button>
					
			</tr>
		</table>

	</form>
</body>
</html>