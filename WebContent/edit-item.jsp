<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Address</title>
</head>
<body>
<form action = "editItemServlet" method="post">
Owner: <input type ="text" name = "owner" value="${itemToEdit.owner}">
Address: <input type = "text" name = "address" value="${itemToEdit.address}">
<input type = "hidden" name = "id" value="${itemToEdit.id}">
<input type = "submit" value="Save Edited Item"> 
</form>
</body>
</html>