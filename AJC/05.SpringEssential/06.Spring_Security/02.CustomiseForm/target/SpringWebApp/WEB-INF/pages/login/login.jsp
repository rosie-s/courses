<%--
  Created by IntelliJ IDEA.
  User: Rosie
  Date: 11/06/2020
  Time: 13:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Log in as user</title>
</head>
<body>
<h1 style="color: mediumvioletred">Login</h1>
<f:form method="POST" >
    <table>
        <tr>
            <td>User:</td>
            <td><input type='text' name='username' value='' placeholder="admin"></td>
        </tr>
        <tr>
            <td>Password:</td>
            <td><input type='password' name='password' placeholder="password"/></td>
        </tr>
        <tr>
            <td><input name="submit" type="submit" value="Submit"/></td>
        </tr>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    </table>
</f:form>

</body>
</html>
