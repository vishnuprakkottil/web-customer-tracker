<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Customer List</title>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css" />

<style>

</style>
</head>
<body>
	<section>
		<div id="header" class="container">
			<h2>Web Customer Tracker</h2>
		</div>
	</section>	
	<section>	
		<div class="container">
			<input class= "button" type="button" value="Add Customer" onclick="window.location.href='addNewCustomer'; return false;"/>
		</div>


	</section>
	<section>
		<div>
			<div id="header" class="container">
				<h2>Customer List</h2>
			</div>
		</div>
		<div class="container">
			<table>
				<tr>
					<th>Sl No</th>
					<th>Customer Id</th>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<th>Edit/Delete</th>
				</tr>

				<c:forEach var="customer" items="${customers}" varStatus="loop">
					<tr>
						<td>${loop.count}</td>
						<td>${customer.id}</td>
						<td>${customer.firstName}</td>
						<td>${customer.lastName}</td>
						<td>${customer.email}</td>
						<td>
						
						<input class= "button" type="button" value="Update" onclick="window.location.href='updateCustomer/${customer.id}'; return false;"/>
						<input class= "button-delete" type="button" value="Delete" onclick="window.location.href='deleteCustomer/${customer.id}'; return false;"/>
						</td>
					</tr>
				</c:forEach>

			</table>
		</div>


	</section>
</body>
</html>