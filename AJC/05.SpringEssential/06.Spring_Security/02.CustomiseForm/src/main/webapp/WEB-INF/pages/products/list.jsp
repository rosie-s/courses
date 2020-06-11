<%--
  Created by IntelliJ IDEA.
  User: Rosie
  Date: 10/06/2020
  Time: 16:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:url var="add" value="${request.contextPath}/product/add"/>

<html>
<head>
    <title>List of Products</title>
</head>
<body>
<h1 style="color: mediumvioletred">List of Products</h1>
<h3 style="color: darkgreen"> Lists of Products </h3>
<c:forEach items="${allProducts}" var="product">
    <c:url var="delete" value="${request.contextPath}/product/delete/${product.id}"/>
    <c:url var="edit" value="${request.contextPath}/product/edit/${product.id}"/>
    <li>
        Product: ${product.name}, Price: ${product.unitPrice},
        <a href="${edit}">[Edit]</a> <a href="${delete}">[X]</a>
    </li>
</c:forEach>
<p style="color: darkgreen">
    <a href="${add}"> Add Product </a><br> <br>
</p>
</body>
</html>
