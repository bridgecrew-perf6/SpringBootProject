<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<a href="/add-address">AddAddress</a><br><br>
<body>
	<table border="1px">
		<tr>
			<th>HOUSE NO</th>
			<th>FLAT</th>
			<th>LANDMARK</th>
			<th>AREA</th>
			<th>CITY</th>
			<th>STATE</th>
			<th>PINCODE</th>
			<th>SELECT</th>
		</tr>
		<c:forEach var="address" items="${addresses }">
			<tr>
				<td>${address.houseno}</td>
				<td>${address.flat}</td>
				<td>${address.landmark}</td>
				<td>${address.area}</td>
				<td>${address.city}</td>
				<td>${address.state}</td>
				<td>${address.pincode}</td>
				<td><a href="/selectaddress?ano=${address.ano }">select</a></td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>