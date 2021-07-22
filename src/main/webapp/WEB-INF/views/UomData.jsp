<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<link
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
	rel="stylesheet">
<style>
body{
max-width:700px;
margin:auto;
}

</style>
</head>
<body>
<div class="card">
    <div class="card-header bg-dark  text-white">
	<h2>Welcome to UOM Data Page</h2>
	</div>
	<div class="card bg-success text-white">
	<div class="card-body">
	<a href="excel"> Excel Export</a> |
	<a href="pdf"> PDF Import</a>
	<table  class="table">
		<tr>
		<th>ID</th>
			<th>TYPE</th>
			<th>MODEL</th>
			<th>DESCRIPTION</th>
			<th colspan="2">OPERATION</th>
		</tr>
		<c:forEach items="${list}" var="um">
			<tr>
			<td><c:out value="${um.uid}" /></td>
				<td><c:out value="${um.type}" /></td>
				<td><c:out value="${um.model}" /></td>
				<td><c:out value="${um.dc}" /></td>
				<td><a href="delete?id=${um.uid}"  class="btn btn-danger">DELETE</a></td>
				<td><a href="edit?id=${um.uid}" class="btn btn-info">EDIT</a></td>
			</tr>
		</c:forEach>
	</table>
	</div>
	<div class="card-footer bg-danger">
	<h4><span style="color:white"> SUCCESS:</span>${message}</h4>
</div>
</body>
</html>
