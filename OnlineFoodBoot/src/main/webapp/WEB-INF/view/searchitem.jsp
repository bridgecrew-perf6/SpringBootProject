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
<table>
			<tr>
				<th>ItemlNo</th>

				<th>HotelNo</th>
				<th>ItemName</th>
				<th>Price</th>
				<th>hotel</th>
			</tr>
			<c:forEach var="item" items="${items }">
				<tr>
					<td>${item.ino}</td>

					<td>${item.hno}</td>
					<td>${item.itemname}</td>
					<td>${item.price}</td>
					<td><a href="/getHotelByHotelNo?hno=${item.hno }">hotel</a>
				</tr>
			</c:forEach>
		</table>

</body>
</html>