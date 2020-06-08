<%--
  Created by IntelliJ IDEA.
  User: Rosie
  Date: 05/06/2020
  Time: 14:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../templates/header.jsp"/>

<h2 style="color: crimson"> Add Login Details </h2>

<c:url var="postUrl" value="/login?action=add"/>
<form action="${postUrl}" method="post">
    <p style="color: midnightblue; font-size: large; font-weight: bold">
        Enter the following details: </p>
    Email:
    <input type="text" name="email" placeholder="Email Address"><br><br>
    Password:
    <input type="password" name="password" placeholder="Password"><br><br>
    <input type="hidden" name="action" value="add">
    <button type="submit">Add</button>
</form>

<jsp:include page="../templates/footer.jsp"/>
