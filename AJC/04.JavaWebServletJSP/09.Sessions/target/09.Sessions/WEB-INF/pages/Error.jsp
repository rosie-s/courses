<%--
  Created by IntelliJ IDEA.
  User: Rosie
  Date: 04/06/2020
  Time: 17:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="../templates/header.jsp"/>
<html>
<head>
    <title>Error</title>
</head>
<body>
<h1 style="color:darkblue"> Hmmm.....Something went wrong :( </h1>
<p> You are connected as: ${sessionScope.user}</p>
</body>
</html>
<jsp:include page="../templates/footer.jsp"/>
