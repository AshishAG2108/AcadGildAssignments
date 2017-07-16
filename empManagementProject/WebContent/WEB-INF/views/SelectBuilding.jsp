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
<h3>Building Details</h3>
<hr size="3" color="gray"/>
<table>

<tr>
<td> Building Id</td>
<td> Building Name</td>
<td> Floor No</td>
</tr>
    <c:forEach items="${seats}" var="seat">
        <tr>
            <td > <c:out value="${seat.buildingId}"/></td>
            <td> <c:out value="${seat.buildingName}"/></td>  
           <a href ="selectSeatFromFloor?floorNo=${seat.floorNo}"> <td> <c:out value="${seat.floorNo}"/></td></a> 
        </tr>
       
      
    </c:forEach>
</table>


</body>
</html>