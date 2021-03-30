<%--
  Created by IntelliJ IDEA.
  User: Tuong Vi
  Date: 29-Mar-21
  Time: 2:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Simple Dictionary</title>
</head>
<body>
<h1>Simple Dictionary</h1><br>
<form action="/translate">
    <h3><label for="word">Word: <input type="text" name="word" id="word" value="${word}"></label>
        <input type="submit" value="Translate">
    </h3>
</form>
</body>
</html>
