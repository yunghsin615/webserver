package myCode;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PostFormServlet extends HttpServlet {

    private PreparedStatement preparedStatement;
    PrintWriter out;

    @Override
    public void init() throws ServletException {
        initializeJDBC();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String price = request.getParameter("price");
        String author = request.getParameter("author");

        storeBook(name, Integer.parseInt(price), author);
        out = response.getWriter();
        out.println("Book has stored.");
        out.close();
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


