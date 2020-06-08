<%--
  Created by IntelliJ IDEA.
  User: Rosie
  Date: 05/06/2020
  Time: 10:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="../templates/header.jsp"/>
<html>
<head>
    <title>Add User</title>
</head>
<body>
<!--Action: the url you want to post the data--->
<form action="?action=add" method="post">
    Enter the following details: <br>
    Name: <br>
    <input type="text" name="name"><br>
    Surname: <br>
    <input type="text" name="surname"><br>
    Salary: <br>
    <input type="number" name="salary"><br>
<%--    <input type="hidden" name="action" value="name">
    <input type="hidden" name="action" value="surname">
    <input type="hidden" name="action" value="salary">--%>
    <button type="submit">Submit</button>
</form>
</body>
</html>
<jsp:include page="../templates/footer.jsp"/>
