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
	
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/add-customer-style.css" />

<style>

</style>
</head>
<body>
	<section>
		<div id="header" class="container">
			<h2>Add New Customer</h2>
		</div>
		<div class ="container">
			<form:form action="saveCustomer" modelAttribute ="customer" method="POST">
				<div class="row">
					<div class="col-25">
						<label for="fname">First Name</label>
					</div>
					<div class="col-75">
						<form:input type="text"  placeholder= "Your First Name" path = "firstName"/>
					</div>
				</div>
				<div class="row">
					<div class="col-25">
						<label for="lname">Last Name</label>
					</div>
					<div class="col-75">
						<form:input type="text" placeholder= "Your Last Name"  path="lastName"/>
					</div>
				</div>
				<div class="row">
					<div class="col-25">
						<label for="email">Email</label>
					</div>
					<div class="col-75">
						<form:input type="email" placeholder= "Your Email"  path="email"/>
					</div>
				</div>
				<br>
				<div class="row">
					<input type="submit" value="Submit"/>
				</div>
			</form:form>
			<p> <a href="${pageContext.request.contextPath}/customer/list"> Back to List</a></p>
		</div>
	</section>
</body>
</html>