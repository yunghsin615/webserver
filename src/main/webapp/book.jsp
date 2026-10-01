<%--
  Created by IntelliJ IDEA.
  User: CCTI-USER
  Date: 2026/10/1
  Time: 上午 11:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="Obj.Book" %>
<html>
  <head>
    <title>Title</title>
  </head>
  <body>
  <%
      List<Book> books = (List<Book>) request.getAttribute("books");
  %>
  <%
    for (Book book : books) {
  %>
    <div>The book from servlet: <%= book.getName() %></div>
    <div>Price: <%= book.getPrice() %></div>
    <div>Author: <%= book.getAuthor() %></div>
    <hr>
    <%
        }
    %>
  </body>
</html>
