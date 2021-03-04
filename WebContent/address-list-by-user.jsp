<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Address List</title>
</head>
<body>
<form method = "post" action = "listnavigationServlet">
<table>
<c:forEach items="${requestScope.allLists}" var="currentlist">
<tr>
   <td><input type="radio" name="id" value="${currentlist.id}"></td>
   <td><h2>${currentlist.listName}</h2></td></tr>
   <tr><td>List Date: ${currentlist.listDate}</td></tr>
   <tr><td>Comment: ${currentlist.comment.comment}</td></tr>
   <c:forEach var = "listVal" items = "${currentlist.listOfItems}">
            <tr><td></td><td>
                ${listVal.owner}, ${listVal.address}
                </td>
            </tr>
  </c:forEach>
</c:forEach>
</table>
<input type = "submit" value = "Edit" name="doThisToList">
<input type = "submit" value = "Delete" name="doThisToList">
<input type="submit" value = "Add" name = "doThisToList">
</form>
<a href="addItemsToListServlet">Create a new List</a>

</body>
</html>