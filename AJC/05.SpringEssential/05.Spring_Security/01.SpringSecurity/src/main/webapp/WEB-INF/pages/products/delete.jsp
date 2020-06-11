<%--
  Created by IntelliJ IDEA.
  User: Rosie
  Date: 10/06/2020
  Time: 16:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete</title>
</head>
<body>
<h1 style="color: red">Deleted Item!!</h1>
<h2 style="color: black">${deleteProduct.name} with ID: ${idDelete} </h2>
</body>

<a href="${pageContext.request.contextPath}/product/list"> Product List </a><br> <br>

</html>
