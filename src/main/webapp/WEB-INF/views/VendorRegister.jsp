<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h3>Welcome to Unit of Measurement Register Page</h3>
	<form:form action="insert" method="POST" modelAttribute="ven">
		<pre>
		
		Vendor Name:<form:input path="venName" />
		
		Vendor Code:<form:input path="venCode" />
		
		Vendor Desg:<form:input path="venDesg" />
		
		Vendor Preserve:<form:input path="venPreserve" />
		
		<input type="submit" value="GenerateVendor" />


</pre>
	</form:form>
	${message}
</body>
</html>