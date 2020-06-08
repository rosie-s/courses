<%--
  Created by IntelliJ IDEA.
  User: Rosie
  Date: 05/06/2020
  Time: 16:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:url var="postUrl" value="/login"/>

<c:if test="${sessionScope.login == null}">
    <form action="${postUrl}" method="post">
        <p style="color: midnightblue; font-size: large; font-weight: bold">
            Please Sign in</p>
        Email:
        <input type="text" name="email" placeholder="Email Address"><br><br>
        Password:
        <input type="password" name="password" placeholder="Password"><br>
        <input type="hidden" name="action" value="login"><br>
        <button type="submit">Login</button>
    </form>
</c:if>
<c:if test="${sessionScope.login != null}">
    <c:url var="logoutUrl" value="/login?action=logout"></c:url>
    <p> You are connected as: ${sessionScope.login.key}</p>
    <p style="color: midnightblue; font-size: large; font-weight: bold">
        <a href="${logoutUrl}">Logout</a>
    </p>
</c:if>
