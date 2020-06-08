<%--
  Created by IntelliJ IDEA.
  User: Rosie
  Date: 05/06/2020
  Time: 14:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../templates/header.jsp"/>

<ul>
    <p style="color: firebrick; font-size: large; font-weight: bold">
    List of users: </p>
    <c:forEach items="${loginList}" var="login">
        <li>
                ${login.email} - <a href="?action=remove&key=${login.key}"> Delete </a>
        </li>
    </c:forEach>
</ul>
<p style="color: darkgreen">
    <a href="?action=add"> Add Login </a>
</p>
<jsp:include page="../templates/footer.jsp"/>
