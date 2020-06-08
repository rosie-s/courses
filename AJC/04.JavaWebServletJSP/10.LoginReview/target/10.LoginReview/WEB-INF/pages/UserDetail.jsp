<%--
  Created by IntelliJ IDEA.
  User: Rosie
  Date: 04/06/2020
  Time: 17:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../templates/header.jsp"/>
<html>
<head>
    <title>Show users</title>
</head>
<body>
Hello, you are connected as ${user.name} ${user.surname} and your salary is
<c:choose>
    <c:when test="${user.salary > 100000}"> High. Niceee!</c:when>
    <c:when test="${user.salary < 20000}"> Low. Get a new job</c:when>
    <c:otherwise>Medium. Do better</c:otherwise>
</c:choose>
</body>
</html>
<jsp:include page="../templates/footer.jsp"/>
