<%--
  Created by IntelliJ IDEA.
  User: Rosie
  Date: 04/06/2020
  Time: 17:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>User List</title>
</head>
<body>
<ul>
    List of users:
    <c:forEach items="${myList}" var="user">
        <li>
            <a href="?action=detail&id=${user.name}">${user.fullName}</a>
        </li>
    </c:forEach>
</ul>
</form>
</body>
</html>
