<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>    
<!DOCTYPE html>
<html>
<head>
</head>
<body>
<a href="/persons">/persons</a>
<a href="/persons/new">/persons/new</a>
<a href="/licenses/new">/licenses/new</a>
<h1>This is This is persons/new</h1>
<form:form action="/persons/new" method="post" modelAttribute="person">
	    <form:input type = "hidden" path="id"/> <br>
	    <form:label path="firstName">First Name</form:label>
	    <form:errors path="firstName"/>
	    <form:input path="firstName"/> <br>
	    <form:label path="lastName">Last Name</form:label>
	    <form:errors path="lastName"/>
	    <form:input path="lastName"/> <br>
    <button type="submit">Submit</button>
</form:form>
</body>
</html>