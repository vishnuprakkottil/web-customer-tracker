<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Customer List</title>
	<link type="text/css" rel="stylesheet" href = "${pageContext.request.contextPath}/resources/css/style.css"/>

	<style>
	* {
		box-sizing: border-box;
	}
	
	body {
		margin: 0;
	}
	
	/* Create three equal columns that floats next to each other */
	.column {
		float: left;
		width: 25%;
		padding: 15px;
	}
	
	/* Clear floats after the columns */
	.row:after {
		content: "";
		display: table;
		clear: both;
	}
	
	.container {
		border-radius: 5px;
		background-color: #f2f2f2;
		padding: 20px;
	}
	
	.col-25 {
		float: left;
		width: 25%;
		margin-top: 6px;
	}
	
	.col-75 {
		float: left;
		width: 75%;
		margin-top: 6px;
	}
	
	/* Clear floats after the columns */
	.row:after {
		content: "";
		display: table;
		clear: both;
	}
	
	/* Left and right column */
	.column.side {
		width: 25%;
	}
	
	/* Responsive layout - when the screen is less than 600px wide, make the two columns stack on top of each other instead of next to each other */
	@media screen and (max-width: 600px) {
		.col-25, .col-75, input[type=submit] {
			width: 100%;
			margin-top: 0;
		}
	
		/* Responsive layout - makes the three columns stack on top of each other instead of next to each other */
		@media screen and (max-width:600px) {
			.column {
				width: 100%;
			}
		}
	}
	</style>
</head>
<body>
	<section>
		<div class="container">
			<h4>List Customer</h4>
		</div>
	</section>
	<section>

		<div class="container">
			<h4>Add New Customer</h4>
		</div>


	</section>
	<section>

		<div id = "wrapper" class ="container">
			<h2>Customer List</h2>
		</div>
		<div class="container">
			<table>
				<tr>
					<th>Sl No</th>
					<th>Customer Id</th>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
				</tr>

				<c:forEach var="customer" items="${customers}" varStatus="loop">
					<tr>
						<td>${loop.count}</td>
						<td>${customer.id}</td>
						<td>${customer.firstName}</td>
						<td>${customer.lastName}</td>
						<td>${customer.email}</td>
					</tr>
				</c:forEach>

			</table>
		</div>


	</section>
</body>
</html>