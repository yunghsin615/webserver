<%--
  Created by IntelliJ IDEA.
  User: CCTI-USER
  Date: 2026/10/1
  Time: 下午 02:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="Obj.Currency" %>
<%@ page errorPage="error.jsp" %>
<html>
  <head>
    <title>Title</title>
  </head>
  <body>
      <%
        int amount = Integer.parseInt(request.getParameter("TWD"));
        Currency currency = new Currency(amount);
      %>

       <h2>日幣: <%= currency.getJPN() %></h2>
       <h2>美金: <%= currency.getUSD() %></h2>
       <h2>人民幣: <%= currency.getCNY() %></h2>
  </body>
</html>
