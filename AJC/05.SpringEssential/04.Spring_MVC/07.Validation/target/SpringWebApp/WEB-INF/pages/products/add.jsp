<%--
  Created by IntelliJ IDEA.
  User: Rosie
  Date: 10/06/2020
  Time: 14:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sp" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Add Product</title>
    <style type="text/css">
        .error {
            color: brown;
        }
    </style>
</head>
<body>
<h1 style="color: mediumvioletred">Add a Product</h1>
<f:form method="POST" action="" modelAttribute="product">

    <sp:hasBindErrors name="product">
        <div><h3 style="color: indigo;"> Error(s): </h3>
            <p>
            <form:errors path="name" cssClass="error"/><br>
            <form:errors path="unitPrice" cssClass="error"/>
            </p>
        </div>
    </sp:hasBindErrors>


    <f:label path="name">The product name</f:label>
    <f:input path="name" placeholder="Television"/> <br><br>

    <f:label path="unitPrice">The Price</f:label>
    <f:input path="unitPrice" placeholder="900.00"/><br><br>

    <f:label path="image">No of images</f:label>
    <f:input path="image" placeholder="0"/><br><br>

    <f:label path="available">Available: true/false</f:label>
    <f:input path="available" placeholder="1"/><br><br>

    <f:label path="quantity">Quantity Remaining</f:label>
    <f:input path="quantity" placeholder="5"/><br><br>

    <f:label path="description">Describe product</f:label>
    <f:input path="description" placeholder="Description goes here"/><br><br>

    <button type="submit">Create</button>
</f:form>

</body>
</html>
