<%--
  Created by IntelliJ IDEA.
  User: CCTI-USER
  Date: 2026/10/4
  Time: 下午 11:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="counter" class="Obj.Counter" scope="application"></jsp:useBean>
<html>
  <head>
    <title>Title</title>
  </head>
  <body>
  <% counter.increaseCount(); %>
    <h5>You are visitor <%= counter.getCount() %></h5>
  </body>
</html>
