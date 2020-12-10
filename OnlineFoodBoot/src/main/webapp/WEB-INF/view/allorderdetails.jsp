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

	<form action="/apply-offer">
		<table border="1px">
			<tr>
				<th>HotelNo</th>
				<th>ItemNo</th>
				<th>ItemName</th>
				<th>Price</th>
			</tr>
			<c:forEach var="c" items="${cart }">
				<tr>
					<td>${c.hotelno}</td>

					<td>${c.itemno}</td>
					<td>${c.itemname}</td>
					<td>${c.price}</td>
				</tr>
			</c:forEach>
		</table>
		<b>Grand Total=${totalprice }</b><br> 
		<b>DelivaryAddress=${hno} ,${flat },${landmark },${area },${city },${state },${country},${pincode}</b><br>
		<br>
		


		<input type="submit" value="continue with order">
	</form>

</body>
</html>