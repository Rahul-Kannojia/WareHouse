<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h3>Welcome to Item Register Page</h3>
	<form:form action="update" method="POST" modelAttribute="item">
		<table>
			<tr>
				<td>Id:</td>
				<form:input path="id" readonly="true" />
			</tr>
			<tr>
				<td>Item Code:</td>
				<td><form:input path="code" /></td>
			</tr>
			<tr>
				<td>Item Dimensions:</td>
				<td>W&nbsp;<input name="w" value="" size="1" type="text">&nbsp;L&nbsp;
					<input name="l" value="" size="1" type="text">&nbsp;H&nbsp;
					<input name="h" value="" size="1" type="text"></td>
			</tr>
			<tr>
				<td>Base Cost:</td>
				<td><form:input path="baseCost" /></td>
			</tr>
			<tr>
		Uom Model    : <form:select path="uom.uid">
	<form:option value="">-select-</form:option>
	<form:options items="${uoms}" itemLabel="model" itemValue="uid"/>
</form:select>	
</tr>
			<tr>
				<td>Base Currency:</td>
				<td><form:select path="baseCurrency">
						<form:option value=" ">--select--</form:option>
						<form:option value="INR">INR</form:option>
						<form:option value="USD">USD</form:option>
						<form:option value="AUS">AUS</form:option>
						<form:option value="ERU">ERU</form:option>
					</form:select> <input type="submit" value="register"></td>

			</tr>
		</table>


	</form:form>
</body>
</html>