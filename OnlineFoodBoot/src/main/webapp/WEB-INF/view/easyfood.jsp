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
	<h1>Welcome to Easy Food</h1>
	<a href="/get-All-Hotels">AllRestaurants</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<a href="/search-hotel">Search</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<a href="/show-cart">Cart</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<a href="/account">Account</a><br><br><br>

	<c:choose>
		<c:when test="${mode=='MODE_All_HOTELS'}">
			<table  border="1px">
				<tr>
					<th>HotelNo</th>

					<th>HotelName</th>
					<th>Rating</th>
					<th>Area</th>
					<th>items</th>
				</tr>
				<c:forEach var="hotel" items="${hotels }">
					<tr>
						<td>${hotel.hno}</td>

						<td>${hotel.hotelname}</td>
						<td>${hotel.rating}</td>
						<td>${hotel.area}</td>
						<td><a href="/getAllItemsByHno?hno=${hotel.hno }">items</a></td>
					</tr>
				</c:forEach>
			</table>
		</c:when>
		
		<c:when test="${mode=='MODE_SEARCH' }">
		<form action="search">
		
		Search:<input type="text" name="hotelname"placeholder="Search By Hotel Name or Item Name">
		<input type="submit" value="search">
		</form>
		</c:when>
		<c:when test="${mode=='MODE_ACCOUNT' }"><br><br>
		<table border="1px">
	<tr><td>	USER DETAILS = ${username }<br></td></tr>
	<tr><td>	<a href="/get-saved-addresses">MANAGE ADDRESS</a><br></td></tr>
	<tr><td>	<a href="/help">HELP</a><br></td></tr>
	<tr><td>	<a href="/logout">LOGOUT</a><br></td></tr>
			</table>
	
		<form action="accountdetails">
		</form>
		
		
		</c:when>
	</c:choose>

</body>
</html>