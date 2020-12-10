<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table>
				<tr>
					<th>HotelNo</th>

					<th>HotelName</th>
					<th>Rating</th>
					<th>Area</th>
					<th>items</th>
				</tr>
					<tr>
						<td>${hotel.hno}</td>

						<td>${hotel.hotelname}</td>
						<td>${hotel.rating}</td>
						<td>${hotel.area}</td>
						<td><a href="/getAllItemsByHno?hno=${hotel.hno }">items</a></td>
					</tr>
			</table>

</body>
</html>