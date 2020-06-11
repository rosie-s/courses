<%--
  Created by IntelliJ IDEA.
  User: Rosie
  Date: 10/06/2020
  Time: 14:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Edit</title>
</head>
<body>
<h1 style="color: mediumvioletred">Edit a Product</h1>
<h2 style="color: darkgreen">Edit ${idEdit.name} with ID: ${idProductEdit}</h2>
<f:form method="POST" action="" modelAttribute="idEdit">
    <f:label path="name">The product name</f:label>
    <f:input path="name" placeholder="Name"/> <br><br>

    <f:label path="unitPrice">The Price</f:label>
    <f:input path="unitPrice" placeholder="Price"/><br><br>

    <f:label path="image">No of Images</f:label>
    <f:input path="image" placeholder="0"/><br><br>

    <f:label path="available">True or false</f:label>
    <f:input path="available" placeholder="1"/><br><br>

    <f:label path="quantity">Quantity Remaining</f:label>
    <f:input path="quantity" placeholder="Price"/><br><br>

    <f:label path="description">Describe product</f:label>
    <f:input path="description" placeholder="Description"/><br><br>

    <button type="submit">Edit ${idEdit.name}</button>
</f:form>

</body>
</html>
