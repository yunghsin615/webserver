<%--
  Created by IntelliJ IDEA.
  User: CCTI-USER
  Date: 2026/10/1
  Time: 下午 02:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Title</title>
  </head>
  <body>
      <%
        double JPN = 4.4382;
        double USD = 0.0345;
        double CNY = 0.2300;
        int TWD = Integer.parseInt(request.getParameter("TWD"));
      %>

       <h2>日幣: <%= TWD * JPN %></h2>
       <h2>美金: <%= TWD * USD %></h2>
       <h2>人民幣: <%= TWD * CNY %></h2>
  </body>
</html>
