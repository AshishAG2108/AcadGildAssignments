<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.List"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
</head>
<body>

	<c:out value="Hello"></c:out>
	<h3>Building Details</h3>
	<hr size="5" color="gray" />
	<table>

		<tr>
			<td>Building Id</td>
			<td>Building Name</td>
			<td>Floor No</td>
			<td>Assign</td>
			<td>Requested By User</td>
		</tr>
		<c:forEach items="${seats}" var="seat">
			<tr>
				<td><c:out value="${seat.buildingId}" /></td>
				<td><c:out value="${seat.seatNo}" /></td>
				<td><c:out value="${seat.floorNo}" /></td>
                 <td><c:out value="${seat.seatStatus}" /></td>
                 <td><c:out value="${seat.requestedByUser}" /></td>                 

	<td><a href="assignSeatStatus?seatNo=${seat.seatNo}&floorNo=${seat.floorNo}&buildingId=${seat.buildingId}">Assign</a></td>

			</tr>

		</c:forEach>
	</table>


</body>
</html>