<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>    
<!DOCTYPE html>
<html>
<head>
</head>
<body>
<a href="/persons">/persons</a>
<a href="/persons/new">/persons/new</a>
<a href="/licenses/new">/licenses/new</a>
<h1>This is new License</h1>
<form:form action="/licenses/new" method="post" modelAttribute="license">
	    <form:label path="person">Person</form:label>
	    <form:errors path="person"/>
            <form:select path="person">
			<c:forEach var="person" items="${persons}">
                <form:option value="${person}">${person.firstName} ${person.lastName}</form:option>
			</c:forEach>
            </form:select>
	    <br>
	    <form:label path="expiration_date">expiration_date</form:label>
	    <form:errors path="expiration_date"/>
	    <form:input type="date" path="expiration_date"/> 
	    <br>
	    <form:label path="state">State </form:label>
	    <form:errors path="state"/>
	    <form:input path="state"/> 
	    <br>
	    <button type="submit">Submit</button>
</form:form>
</body>
</html>