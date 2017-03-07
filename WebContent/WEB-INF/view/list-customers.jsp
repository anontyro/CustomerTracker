<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<%@ include file="header.jsp" %>

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
		
		<input type="button" value="Add Customer" class="btn btn-default"
		onclick="window.location.href='showFormForAdd'; return false;" 
		/>
		<br><br>
		<table class="table table-striped">
			<tr>
				<th>Firstname </th>
				<th>Lastname</th>
				<th>Email</th>
				<th>Actions</th>
			</tr>
			
			<!-- loop over the customers -->
			<c:forEach var="tempCustomer" items="${customers}">
			
			<c:url var = "updateLink" value="/customer/showFormForUpdate">
				<c:param name="customerId" value ="${tempCustomer.id}" />
			</c:url>
			
			<c:url var = "deleteLink" value = "/customer/delete">
				<c:param name="customerId" value="${tempCustomer.id}" />
			</c:url>
			
			<tr>
				<td>${tempCustomer.firstname} </td>
				<td>${tempCustomer.lastname} </td>
				<td>${tempCustomer.email} </td>
				<td>
					<a href="${updateLink}">Update</a>
					|
					<a href="${deleteLink}"
					onclick="if(!(confirm('Are you sure you want to delete the customer?'))) return false">
					Delete
					</a>
				</td>
			</tr>
			
			</c:forEach>
			
		</table>
		
		</div>
	</div>

</body>
</html>