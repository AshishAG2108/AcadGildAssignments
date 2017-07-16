<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
</head>
<body>

<c:out value="Hello"></c:out>
<h3>Floor Details</h3>
<hr size="3" color="gray"/>
<table>
<tr>
<td> Floor No</td>
<td> Seat No</td>
<td> Seat Status</td>
</tr>
    <c:forEach items="${selSeat}" var="seat">
        <tr>
            <td> <c:out value="${seat.floorNo}"/></td>
             <a href ="seatSelected?seatNo=${seat.seatNo}"><td> <c:out value="${seat.seatNo}"/></td>  </a> 
           <td> <c:out value="${seat.seatStatus}"/></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>