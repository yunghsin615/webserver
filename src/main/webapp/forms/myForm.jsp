<%--
  Created by IntelliJ IDEA.
  User: CCTI-USER
  Date: 2026/9/23
  Time: 上午 10:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Title</title>
  </head>
  <body>
    <form action="http://localhost:8080/sessionRegister" method="get">
        <label>Book Name: </label>
        <input type="text" name="name">
        <br>
        <label>Price: </label>
        <input type="number" name="price">
        <br>
        <label>Author: </label>
        <input type="text" name="author">
        <br>
        <input type="submit" value="submit">

        <%--
        <br>
        <label>: </label>
        <input type="" name="">
        --%>
    </form>
  </body>
</html>
