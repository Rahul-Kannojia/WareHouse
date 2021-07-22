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
<body bgcolor="#E6E6FA" >
<div class="card">
    <div class="card-header bg-danger  text-white">
	<h3>Welcome to Unit of Measurement Register Page</h3>
	</div>
<div class="card bg-info text-white">
	<form:form action="update" method="POST" modelAttribute="um"><br>
			<pre>
&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbspID      :   <form:input path="uid" readonly="true"/><br><br>
&nbsp&&nbsp&nbspnbspUOM TYPE:   <form:select path="type">
            <form:option value=" ">---NA---</form:option>
            <form:option value="PARKING">Parking</form:option>
            <form:option value="NOPARKING">NoParking</form:option></form:select>
            
&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbspUOM MODEL:  <form:input path="model"/>

&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbspDESCRIPTION:<form:textarea path="dc" />

&nbsp&nbsp&nbsp&nbsp<input type="submit" value="GenerateUOM" /class="btn btn-primary" style="margin-left:120px;">

</pre>
		</form:form>
		</div>
		<div class="card-footer bg-danger">
		<h3><span style="color:white"> SUCCESS:</span>${massege}</h3>
</div>
</body>
</html>
