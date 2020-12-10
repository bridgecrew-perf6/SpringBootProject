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
	<br> <a href="/get-All-Hotels">add more items</a><br><br>
	<!--<form action="/save-into-order">-->
		  <form action="get-saved-addresses">
	
		<table align="left" border="1px">
			<tr>
				<th>HotelNo</th>
				<th>ItemNo</th>
				<th>ItemName</th>
				<th>Price</th>
				<th>Remove</th>
				
			</tr>
			<c:forEach var="c" items="${cart }">
				<tr>
					<td>${c.hotelno}</td>
					<td>${c.itemno}</td>
					<td>${c.itemname}</td>
					<td>${c.price}</td>
					<td><a href="/removefromcart?no=${c.no }">remove</a></td>
				</tr>
			</c:forEach>
			<tr><td colspan="5"><b>Grand Total=${totalprice }</b> </td></tr>
			<tr><td colspan="5"><input style="width: 100%"type="submit" value="continue with cart" ></td></tr>
		</table>
		 
	</form>



</body>
</html>