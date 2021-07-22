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
	<h2>Welcome to Employee Data Page</h2>
	<a href="excel"> Excel Export</a> |
	<a href="pdf"> PDF Import</a>
	<table border="1">
		<tr>
			<th>ID</th>
			<th>SHIPMENT TYPE</th>
			<th>SHIPMENT CODE</th>
			<th>ENABLE SHIPMENT</th>
			<th>SHIPMENT GRADE</th>
			<th>DESCRIPTION</th>
			<th colspan="2">OPERATION</th>
		</tr>
		<c:forEach items="${list}" var="st">
			<tr>
				<td><c:out value="${st.id}"/></td>
				<td><c:out value="${st.mode}"/></td>
				<td><c:out value="${st.code}"/></td>
				<td><c:out value="${st.enabled}"/></td>
				<td><c:out value="${st.grade}"/></td>
				<td><c:out value="${st.dsc}"/></td>
				<td><a href="delete?id=${st.id}">DELETE</a></td>
				<td><a href="edit?id=${st.id}">EDIT</a></td>
			</tr>
		</c:forEach>
	</table>
	<h4>${message}</h4>
</body>
</html>