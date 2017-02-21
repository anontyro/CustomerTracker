<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/style/bootstrap.min.css" />
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/style/style.css" />

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Customer List</title>
</head>
<body>

	<div id="container">
		<div id="header">
		<h2>Customer Relationship Manager</h2>
		</div>
	</div>
	
	<div id="main-container">
		<div id="content">
		
		<table>
			<tr>
				<th>Firstname </th>
				<th>Lastname</th>
				<th>Email</th>
			</tr>
			
			<!-- loop over the customers -->
			<c:forEach var="tempCustomer" items="${customers}">
			
			<tr>
				<td>${tempCustomer.firstname} </td>
				<td>${tempCustomer.lastname} </td>
				<td>${tempCustomer.email} </td>
			</tr>
			
			</c:forEach>
			
		</table>
		
		</div>
	</div>

</body>
</html>