<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>Welcome to Item Data Page</h2>
	<table border="1">
		<tr>
			<th>ID</th>
			<th>CODE</th>
			<th>DIMENSIONS</th>
			<th>BASECOST</th>
			<th>BASECURRENCY</th>
			<th>WhVendor</th>
			<th>WhCustomer</th>
			<th colspan="2">OPERATION</th>
		</tr>
		<c:forEach items="${list}" var="list">
			<tr>

				<td><c:out value="${list.id}" /></td>
				<td><c:out value="${list.code}" /></td>
				<td><c:out value="${list.w}" />x <c:out value="${list.l}" />x
					<c:out value="${list.h}" /></td>

				<td><c:out value="${list.baseCost}" /></td>
				<td><c:out value="${list.baseCurrency}" /></td>
				<td><c:out value="${itm.saleType.code}" /></td>
				<td><c:out value="${itm.purchaseType.code}" /></td>

				<td><c:forEach items="${itm.venUsers}" var="ven"> 
				       
						<c:out value="${ven.code}" />,
				</c:forEach></td>
				<td><c:forEach items="${itm.custUsers}" var="cust">
						<c:out value="${cust.code}" />,
				</c:forEach></td>

				<td><a href="delete?id=${list.id}">DELETE</a></td>
				<td><a href="edit?id=${list.id}">EDIT</a></td>
		</c:forEach>
	</table>
	<h2>${message}</h2>
</body>
</html>