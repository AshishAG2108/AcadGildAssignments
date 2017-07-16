
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee Welcome Screen</title>
</head>
<body>
	<center>
		<h2>Hello ${username}</h2>
		<h2>
			
		</h2>
	</center>
	<a href="BookSeat.jsp">Click to Book Seat</a>
	<a href ="BookedSeatStatus.jsp">Click to view seat Status</a>
	<%-- <c:if test="${username} =='Admin'">
	
	</c:if> --%>
	
</body>
</html>