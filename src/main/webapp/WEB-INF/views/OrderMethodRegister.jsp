<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
<body>
<br>
<div class="card">
    <div class="card-header bg-dark text-white">
	<h3>WELCOME TO ORDER METHOD REGISTER PAGE!!</h3>
	</div>
	<div class="card bg-info text-white">
	<form:form action="insert" method="POST" modelAttribute="orderMethod">
		<pre>
&nbsp&nbsp&nbsp&nbspORDER MODE  : <form:radiobutton path="mode" value="Sale" /> Sale <form:radiobutton
				path="mode" value="Purchase" /> Purchase
            <form:errors path="mode" cssClass="err" /> 

&nbsp&nbsp&nbsp&nbspORDER CODE  : <form:input path="code" />
           <form:errors path="code" cssClass="err" />

&nbsp&nbsp&nbsp&nbspORDER METHOD: <form:select path="method">
<form:option value="">-SELECT-</form:option>
<form:option value="fifo">FIFO</form:option>
<form:option value="lifo">LIFO</form:option>
<form:option value="fcfo">FCFO</form:option>
<form:option value="fefo">FEFO</form:option>
</form:select>
<form:errors path="method" cssClass="err" />
&nbsp&nbsp&nbsp&nbspORDER ACCEPT: <form:checkbox path="accept" value="multimode" />MULTIMODE<form:checkbox
				path="accept" value="acceptreturn" />ACCEPET RETURN

&nbsp&nbsp&nbsp&nbspDESCRIPTION:  <form:textarea path="dc" />
     <form:errors path="dc" cssClass="err" />

<input type="submit" value="GENERATE_ORDER_METHOD" / class="btn btn-primary" style="margin-left:120px;"><br><br>
>
</pre>
	</form:form>
	</div>
		<div class="card-footer bg-danger text-white">
	<span style="color:white"> SUCCESS:</span>${massege}
	</div>
</body>
</html>
