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

	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script type="text/javascript">
		function fun() {
			var a = $("#whusr").val();
			if (a == 4) {
				$("#ifothr").removeAttr('readonly');
			} else {
				$("#ifothr").attr('readonly', true);
			}
		}
	</script>

	<h3>WELCOME TO WAHERHOUSE TYPE USER REGISTER PAGE</h3>

		<form:form action="update" method="POST" modelAttribute="wt">
			<pre>
ID       :<form:input path="id" readonly="true"/>

USER TYPE:   <form:radiobutton path="type" value="vendor" />VENDOR<form:radiobutton path="type" value="customer" />CUSTOMER

USER CODE :  <form:input path="code" />

USER FOR  :  <form:input path="forType" />

USER EMAIL:  <form:input path="email" />

USER CONTACT:<form:input path="contact" />

USER_ID TYPE:<form:select path="idType" id="whusr" onchange="fun()">
<form:option value="0">---PLEASE SELECT---</form:option>
<form:option value="1">PAN</form:option>
<form:option value="2">AADHAR</form:option>
<form:option value="3">VOTER</form:option>
<form:option value="4">OTHER</form:option>
</form:select>

*IF OTHERS:  <form:input path="ifOther" id="ifothr" />

ID NUMBER :  <form:input path="idNum" />

	<input type="submit" value="CREATE_USER" />
</pre>
		</form:form>
	
<h3>${massege}</h3>
</body>
</html>