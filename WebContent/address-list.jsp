<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<style>
table, th, td {
  border: 1px solid black;
}
</style>
<title>Shopping List</title>
</head>
<body>
<form method = "post" action = "navigationServlet" >
<table>
<c:forEach items="${requestScope.allItems}" var="currentitem">
<tr>
	<td><input type="radio" name="id" value="${currentitem.id}"></td>
	<td>${currentitem.owner}</td>
	<td>${currentitem.address}</td>
	</tr>
</c:forEach>
</table>
<br />
<input type = "submit" value = "Edit" name="doThisToItem" class="btn btn-warning">
<input type = "submit" value = "Delete" name="doThisToItem" class="btn btn-danger">
<input type="submit" value = "Add" name = "doThisToItem" class="btn btn-success">
</form>
</body>
</html>