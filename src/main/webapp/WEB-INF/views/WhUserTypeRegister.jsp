<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
		function onTypeEvent(userFor) {
			document.getElementById("forType").value = userFor;
			document.getElementById("forType").readonly = true;
		}
	</script>

	<h3>WELCOME TO WAHERHOUSE TYPE USER REGISTER PAGE</h3>

	<form:form action="insert" method="POST" modelAttribute="whuserType">
		<pre>
USER TYPE:   <form:radiobutton path="type" value="vendors"
				/>VENDOR
                   <form:radiobutton path="type" value="customers"
				/>CUSTOMER
                 
USER CODE :  <form:input path="code" />
                   <form:errors path="code" cssClass="err" />
                   

USER FOR  :  <form:input path="forType" id="forType" value=""
				 />
                   <form:errors path="forType" cssClass="err" />  

USER EMAIL:  <form:input path="email" />
                   <form:errors path="email" cssClass="err" />

USER CONTACT:<form:input path="contact" />
                      <form:errors path="contact" cssClass="err" />

USER_ID TYPE:<form:select path="idType" id="whusr" onchange="fun()">
<form:option value="0">---PLEASE SELECT---</form:option>
<form:option value="1">PAN</form:option>
<form:option value="2">AADHAR</form:option>
<form:option value="3">VOTER</form:option>
<form:option value="4">OTHER</form:option>
</form:select>
<form:errors path="idType" cssClass="err" />

*IF OTHERS:  <form:input path="ifOther" id="ifothr" />
                    <form:errors path="ifOther" cssClass="err" />

ID NUMBER :  <form:input path="idNum" />
                   <form:errors path="idNum" cssClass="err" />

	<input type="submit" value="CREATE_USER" />
</pre>
	</form:form>

	<h3>${massege}</h3>
</body>
</html>