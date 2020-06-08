<%--
  Created by IntelliJ IDEA.
  User: Rosie
  Date: 05/06/2020
  Time: 10:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../templates/header.jsp"/>
<html>
<head>
    <title>Add User</title>
</head>

<body>
<c:url var="postUserUrl" value="/user"/>

<ul>
    <li> PageScope: ${pageScope.postUserUrl}</li>
    <li> RequestScope: ${requestScope.postUserUrl}</li>
    <li> SessionScope: ${sessionScope.postUserUrl}</li>
    <li> ApplicationScope: ${applicationScope.postUserUrl}</li>
</ul>

<!--Action: the url you want to post the data--->
<form action="${postUserUrl}" method="post">
    Enter the following details: <br><br>
    Name: <br>
    <input type="text" name="name"><br>
    Surname: <br>
    <input type="text" name="surname"><br>
    Salary: <br>
    <input type="number" name="salary"><br>

    <button type="submit">Submit</button>
</form>
</body>
</html>
<jsp:include page="../templates/footer.jsp"/>
