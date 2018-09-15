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
<h1>This is show</h1>
<h2> ${person.firstName}   ${person.lastName}</h2>

<table>
<tbody>
	<tr>
		<td>License Number</td>
		<td></td>
		<td>${license.number}</td>
	</tr>
	<tr>
		<td>State</td>
		<td></td>
		<td>${license.state}</td>
	</tr>
	<tr>
		<td>Expiration Date</td>
		<td></td>
		<td>${license.expiration_date}</td>
	</tr>
</tbody>
</table>

</body>
</html>