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
	<h3>WELCOME TO ORDER METHOD REGISTER PAGE</h3>
	<form:form action="update" method="POST" modelAttribute="ordm">
			<pre>
ID          :<form:input path="id" readonly="true"/>
ORDER MODE  : <form:radiobutton path="mode" value="sale" />SALE<form:radiobutton path="mode" value="purchase" />PURCHASE

ORDER CODE  : <form:input path="code"/>

ORDER METHOD: <form:select path="method">
<form:option value="">
-SELECT-      </form:option>
<form:option value="fifo">FIFO</form:option>
<form:option value="lifo">LIFO</form:option>
<form:option value="fcfo">FCFO</form:option>
<form:option value="fefo">FEFO</form:option>
</form:select>
ORDER ACCEPT: <form:checkbox path="accept" value="multimode" />MULTIMODE<form:checkbox path="accept" value="acceptreturn"/>ACCEPET RETURN

DESCRIPTION:  <form:textarea path="dc" />

<input type="submit" value="GENERATE_ORDER_METHOD" />
</pre>
		</form:form>
		<h4>${massege}</h4>
</body>
</html>
