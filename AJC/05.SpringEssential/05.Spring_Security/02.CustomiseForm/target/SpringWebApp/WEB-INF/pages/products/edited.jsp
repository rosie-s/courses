<%--
  Created by IntelliJ IDEA.
  User: Rosie
  Date: 10/06/2020
  Time: 12:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>

<html>
<head>
    <title>Product page</title>
</head>
<body>
<h1 style="color: darkolivegreen">Product Edited!! </h1>
<h2 style="color: darkblue">${idEdited.name} with ID: ${idProductEdited}</h2>
</body>
<a href="${pageContext.request.contextPath}/product/list"> Product List </a><br>
</html>
