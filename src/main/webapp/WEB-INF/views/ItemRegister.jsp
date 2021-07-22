<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
<style type="text/css">
.err {
	color: red;
}
</style>

</head>
<body bgcolor="#E6E6FA">
	<div class="card">
		<div class="card-header bg-success text-white">
			<h2>Welcome to Item Register Page</h2>
		</div>
		<div class="card-body">
			<pre>
	<form:form action="insert" method="POST" modelAttribute="item">
	
Item Code:         <form:input path="code" />
                    <form:errors path="code" cssClass="err" />

Item Dimensions:W<form:input path="w" size="5" /> <form:errors path="w"
						cssClass="err" />L<form:input path="l" size="5" />
                         <form:errors path="l" cssClass="err" />H<form:input
						path="h" size="5" /> <form:errors path="h" cssClass="err" />
				
				
Uom Model : <form:select path="uom.uid">
	<form:option value="">-select-</form:option>
	<form:options items="${uoms}" itemLabel="model" itemValue="uid" />
</form:select>
<form:errors path="uom" cssClass="err" />	

Order Method:(SaleType)
                 <form:select path="saleType.id">
                 <form:option value="">--SELECT--</form:option>
                 <form:options items="${sales}" itemLabel="code"
							itemValue="id" />
                 </form:select>
                 <form:errors path="saleType" cssClass="err" />
 Order Method:(purchaseType)
                   <form:select path="purchaseType.id">
                   <form:option value="">--SELECT--</form:option>
                   <form:options items="${purchases}" itemLabel="code"
							itemValue="id" />
                   </form:select>
                   <form:errors path="purchaseType" cssClass="err" />
                   
Item Vendors:
                   <form:select path="venUsers"> 
                   
                   <form:option value="">--SELECT--</form:option>
                   <form:options items="${vendors}" itemLabel="code"
							itemValue="id" />
                   </form:select>   
                   
Item Customers:
                   <form:select path="custUsers">
                   <form:option value="">--SELECT--</form:option>
                   <form:options items="${customers}" itemLabel="code"
							itemValue="id" />
                   </form:select>                   
			
Base Cost:         <form:input path="baseCost" />
                      <form:errors path="baseCost" cssClass="err" />

Base Currency:     <form:select path="baseCurrency">
						<form:option value=" ">--select--</form:option>
						<form:option value="INR">INR</form:option>
						<form:option value="USD">USD</form:option>
						<form:option value="AUS">AUS</form:option>
						<form:option value="ERU">ERU</form:option>
					</form:select> 
					<form:errors path="baseCurrency" cssClass="err" />
					
		         <input type="submit" value="register">

	</form:form>
	</pre>
		</div>
		<div class="card-footer bg-success">
			<span style="color: white"> SUCCESS:</span>${message}
		</div>
	</div>
</body>
</html>