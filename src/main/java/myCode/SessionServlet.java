package myCode;

import Obj.Book;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet(name="SessionServlet", value="/SessionServlet")
public class SessionServlet extends HttpServlet {
    private PreparedStatement preparedStatement;
    PrintWriter out;

    @Override
    public void init() throws ServletException {
        initializeJDBC();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        String name = request.getParameter("name");
        String price = request.getParameter("price");
        String author = request.getParameter("author");

        Book book = new Book();
        book.setName(name);
        book.setPrice(Integer.parseInt(price));
        book.setAuthor(author);

        HttpSession httpSession = request.getSession();
        httpSession.setAttribute("book", book);

        out = response.getWriter();
        out.println("<p>Book Name: " + name + "</p><br>");
        out.println("<p>Book Price: " + price + "</p><br>");
        out.println("<p>Book Author: " + author + "</p>");

        out.println("<form method=\"post\" action=\"/sessionRegister\">");
        out.println("<input type=\"submit\" value=\"Confirm\"></form>");

        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession httpSession = request.getSession();
        Book book = (Book) httpSession.getAttribute("book");

        try {
            storeBook(book.getName(), book.getPrice(), book.getAuthor());
            out = response.getWriter();
            out.println("Book has been stored.");
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void initializeJDBC() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded");

            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/KaydenceDB", "Kaydence", "password");
            System.out.println("DB Connected");

            preparedStatement = conn.prepareStatement("insert into Book" + "(name, price, author) values  (?, ?, ?)" );
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void storeBook(String name, int price, String author){
        try {
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, price);
            preparedStatement.setString(3, author);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
