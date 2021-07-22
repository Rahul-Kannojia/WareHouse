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
	<form:form action="update" method="POST" modelAttribute="stm">
			<pre>
ID             :<form:input path="id" readonly="true"/>
SHIPMENT MODE  :<form:select path="mode">
<form:option value="">
-SELECT-</form:option>
<form:option value="air">AIR</form:option>
<form:option value="truck">TRUCK</form:option>
<form:option value="ship">SHIP</form:option>
<form:option value="train">TRAIN</form:option>
</form:select>

SHIPMENT CODE  :<form:input path="code"/>

ENABLE SHIPMENT:<form:checkbox path="enabled" value="yes"/>YES

SHIPMENT GRADE :<form:radiobutton path="grade" value="a" />A<form:radiobutton path="grade" value="b" />B<form:radiobutton path="grade" value="c" />C

DESCRIPTION    :<form:textarea path="dsc" />

<input type="submit" value="GENERATE_SHIPMENT" />
</pre>
		</form:form>
		${massege}
</body>
</html>
