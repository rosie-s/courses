<%--
  Created by IntelliJ IDEA.
  User: Rosie
  Date: 11/06/2020
  Time: 10:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sp" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Add User</title>
    <style type="text/css">
        .error {
            color: brown;
        }
    </style>
</head>
<body>
<h1 style="color: mediumvioletred">Add a User</h1>
<f:form method="POST" action="" modelAttribute="user">

    <sp:hasBindErrors name="user">
        <div><h3 style="color: indigo;"> Error(s): </h3>
            <p>
                <f:errors path="login" cssClass="error"/><br>
                <f:errors path="password" cssClass="error"/><br>
            </p>
        </div>
    </sp:hasBindErrors>


    <f:label path="login">Username</f:label>
    <f:input path="login" placeholder="Username"/> <br><br>

    <f:label path="password">Password</f:label>
    <f:input path="password" placeholder="password"/><br><br>

    <f:label path="passwordConfirm">Confirm Password</f:label>
    <f:input path="passwordConfirm" placeholder="Confirm password"/><br><br>

    <button type="submit">Create</button>
</f:form>

</body>
</html>
