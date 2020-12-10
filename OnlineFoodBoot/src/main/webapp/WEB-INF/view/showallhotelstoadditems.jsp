<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
		<a href="/register-hotel">back</a>&nbsp;&nbsp;&nbsp;&nbsp;
		<a href="/login-customer">home</a><br><br>
		

	
		<table border="1px">
			<tr>
				<th>HotelNo</th>
				<th>HotelName</th>
				<th>Rating</th>
				<th>Area</th>
				<th>Additems</th>
			</tr>
			<c:forEach var="hotel" items="${hotels }">
				<tr>
					<td>${hotel.hno}</td>
					<td>${hotel.hotelname}</td>
					<td>${hotel.rating}</td>
					<td>${hotel.area}</td>
					<td><a href="/add-items-h?hno=${hotel.hno }">Add items</a></td>
				</tr>
			</c:forEach>
		</table>
	
</body>
</html>