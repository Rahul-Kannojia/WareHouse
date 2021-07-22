<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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

<style type="text/css">
.err {
	color: red;
}
body
{
max-width:700px;
margin:auto;
}
</style>

</head>
<body bgcolor="#E6E6FA">
<br>
<div class="card">
    <div class="card-header bg-dark text-white">

	<h3>Welcome to Unit of Measurement Register Page</h3>
	</div>
	<div class="card bg-info text-white">
	<form:form action="insert" method="POST" modelAttribute="uom"><br>
		
&nbsp&nbspUOM TYPE:  &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp <form:select path="type">
            <form:option value=" ">--SELECT--</form:option>
            <form:option value="PARKING">Parking</form:option>
            <form:option value="NOPARKING">NoParking</form:option>
            <form:option value=" ">---NA---</form:option>
            </form:select><br><br>
            
            <form:errors path="type" cssClass="err" />
            
            
            
&nbsp&nbspUOM MODEL: &nbsp <form:input path="model" /><br><br>
<form:errors path="model" cssClass="err" />

&nbsp&nbspDESCRIPTION:&nbsp&nbsp<form:textarea path="dc" /><br><br>
<form:errors path="dc" cssClass="err" />

<input type="submit" value="GenerateUOM" / class="btn btn-primary" style="margin-left:120px;"><br><br>

	</form:form>
	</div>
	<div class="card-footer bg-danger text-white">
	<span style="color:white"> SUCCESS:</span>${massege}
</div>
</div>
</body>
</html>
