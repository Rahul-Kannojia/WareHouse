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
	<h2>Welcome to OrderMethod Data Page</h2>
	<a href="excel"> Excel Export</a> |
	<a href="pdf"> PDF Import</a>
	
	<table border="1">
		<tr>
			<th>ID</th>
			<th>ORDER MODE</th>
			<th>ORDER CODE</th>
			<th>DESCEREPTION</th>
			<th>ORDER METHOD</th>
			<th>ORDER ACCEPET</th>
			<th colspan="2">OPERATION</th>
		</tr>
		<c:forEach items="${list}" var="omd">
			<tr>
				<td><c:out value="${omd.id}" /></td>
				<td><c:out value="${omd.mode}" /></td>
				<td><c:out value="${omd.code}" /></td>
				<td><c:out value="${omd.dc}" /></td>
				<td><c:out value="${omd.method}" /></td>
				<td><c:out value="${omd.accept}" /></td>
				<td><a href="delete?id=${omd.id}">DELETE</a></td>
				<td><a href="edit?id=${omd.id}">EDIT</a></td>
				
			</tr>
		</c:forEach>
	</table>
	<h4>${message}</h4>
</body>
</html>
