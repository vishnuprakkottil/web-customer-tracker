<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
			<input class="button" type="button" value="Add Customer"
				onclick="window.location.href='addNewCustomer'; return false;" />
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
					<th>Action</th>
				</tr>

				<c:forEach var="customer" items="${customers}" varStatus="loop">
					<tr>
						<td>${loop.count}</td>
						<td>${customer.id}</td>
						<td>${customer.firstName}</td>
						<td>${customer.lastName}</td>
						<td>${customer.email}</td>
						<td>
							<!-- <c:url var="update" value="/customer/viewCustomer">
								<c:param name="customerId" value="${customer.id}" />
							</c:url> 
							
							<a href="${update}">update</a> -->
							<div class="row">
								<div class="col-25">
									<form
										action="${pageContext.request.contextPath}/customer/viewCustomer"
										method="GET">
										<input type="hidden" name="customerId" value="${customer.id}" />
										<button class="button" type="submit">Update</button>
									</form>
								</div>								
								<div class="col-75">
									<form
										action="${pageContext.request.contextPath}/customer/deleteCustomer"
										method="GET">
										<input type="hidden" name="customerId" value="${customer.id}" />
										<button class="button-delete" type="submit">Delete</button>
									</form>
								</div>
							</div> 
							<!--
							<form:form action="${update}" modelAttribute="customer">
								<input class="button" type="button" value="Update "/>
								<input class= "button-delete" type="button" value="Delete" onclick="window.location.href='deleteCustomer/${customer.id}'; return false;"/>
						 		
							</form:form>-->
						</td>
					</tr>
				</c:forEach>

			</table>
		</div>


	</section>
</body>
</html>