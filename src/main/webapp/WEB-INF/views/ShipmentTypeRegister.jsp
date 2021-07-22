<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<style type="text/css">
.err {
	color: red;
}
</style>

</head>
<body>
	<h3>WELCOME TO ShipmentType  REGISTER PAGE</h3>
	<form:form action="insert" method="POST" modelAttribute="shipmentType">
		<pre>
			
SHIPMENT MODE  :<form:select path="mode">
<form:option value="">
-SELECT-</form:option>
<form:option value="air">AIR</form:option>
<form:option value="truck">TRUCK</form:option>
<form:option value="ship">SHIP</form:option>
<form:option value="train">TRAIN</form:option>
</form:select>
<form:errors path="mode" cssClass="err" />
SHIPMENT CODE  :<form:input path="code" />
                        <form:errors path="code" cssClass="err" />

ENABLE SHIPMENT:<form:checkbox path="enabled" value="yes" />YES
                           <form:errors path="enabled" cssClass="err" />

SHIPMENT GRADE :<form:radiobutton path="grade" value="a" />A<form:radiobutton
				path="grade" value="b" />B<form:radiobutton path="grade" value="c" />C
                           <form:errors path="grade" cssClass="err" />
                           
DESCRIPTION    :<form:textarea path="dsc" />
                       <form:errors path="dsc" cssClass="err" />

<input type="submit" value="GENERATE_SHIPMENT" />
</pre>
	</form:form>
	<h3>${massege}</h3>
</body>
</html>
