<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
<%@ include file="header.jsp" %>
<title>Save Customer Details</title>
</head>
<body>

<div id="header">
	<h2>Customer Relationship Manager</h2>
</div>

<form:form action="saveCustomer" modelAttribute="customer" method="POST" class="form-horizontal">
	
	<!-- used for updating to associate this data with the customer id -->
	<form:hidden path="id"/>

	<div class="form-group">
		<label>First Name</label>
		<form:input path="firstname" class="form-control" />
		
		<label>Last Name</label>
		<form:input path="lastname" class="form-control" />
		
		<label>E-Mail</label>
		<form:input path="email" class="form-control" />
		
	
	</div>
	
	<div class="form-group">
		<input type="submit" value="Save" class="save btn btn-primary"/>
		<a href = "${pageContext.request.contextPath}/customer/list" class="btn btn-default">Back</a>
	</div>

</form:form>

</body>
</html>