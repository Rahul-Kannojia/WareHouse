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
	<h2>Welcome to Welcome to WahereHouseUserType Data Page</h2>
	<a href="excel"> Excel Export</a> |
	<a href="pdf"> PDF Import</a>
	<table border="1">
		<tr>
			<th>ID</th>
			<th>USER TYPE</th>
			<th>USER CODE</th>
			<th>USER FOR</th>
			<th>USER EMAIL</th>
			<th>USER CONTACT</th>
			<th>USER ID TYPE</th>
			<th>ID NUMBER</th>
			<th colspan="2">OPERATION</th>		
		</tr>
		<c:forEach items="${list}" var="wht">
			<tr>
				<td><c:out value="${wht.id}" /></td>
				<td><c:out value="${wht.type}" /></td>
				<td><c:out value="${wht.code}" /></td>
				<td><c:out value="${wht.forType}" /></td>
				<td><c:out value="${wht.email}" /></td>
				<td><c:out value="${wht.contact}" /></td>
				<td><c:out value="${wht.idType}" /></td>
				<td><c:out value="${wht.idNum}" /></td>
				<td><a href="delete?id=${wht.id}">DELETE</a></td>
				<td><a href="edit?id=${wht.id}">EDIT</a></td>
			</tr>
		</c:forEach>
	</table>
	<h4>${message}</h4>
</body>
</html>