<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<style>
table {
	border-collapse: collapse;
	width: 100%;
}

th, td {
	text-align: left;
	padding: 8px;
}

tr:nth-child(even) {
	background-color: #f2f2f2;
}
</style>
<meta charset="ISO-8859-1">
<title>Cart List</title>
</head>
<body >

	<div>
		<jsp:include page="header.jsp"></jsp:include>
	</div>
	<div align=right>
		<a href="refresh.app">Home</a>
	</div>
	<div align=center>
		<h1>Cart List</h1>
		<jstl:if test="${sessionScope.cartList.size() > 0 }">
			<table>
				<tr>
					
					<th>Book Name</th>
					<th>Price</th>
					<th>Count</th>
					<th>Description</th>
					<th>Author</th>

				</tr>
				<jstl:forEach var="cart" items="${sessionScope.cartList }">
					<tr>
						
						<td>${cart.bookName}</td>
						<td>${cart.price}</td>
						<td>${cart.bookCount}</td>
						<td>${cart.description}</td>
						<td>${cart.author}</td>

						<td><a href="delete.app?bookName=${cart.bookName}">Remove
								from cart</a></td>


					</tr>
				</jstl:forEach>
			</table>
		</jstl:if>
		<jstl:if test="${sessionScope.cartList.size() == 0 }">

			<h3>No books to display in the cart</h3>


		</jstl:if>


	</div>
	<div>
		<jsp:include page="footer.jsp"></jsp:include>
	</div>
</body>
</html>