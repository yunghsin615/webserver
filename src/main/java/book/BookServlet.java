package book;

import Obj.Book;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.*;

@WebServlet(name="BookServlet", value="/BookServlet")
public class BookServlet extends HttpServlet {

    private Connection conn;
    private PreparedStatement preparedStatement;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        initializeJDBC();

        String name = request.getParameter("name");
        String author = request.getParameter("author");

//        擇一必填
        if ((name == null || name.isBlank()) && (author == null || author.isBlank())) {
            return;
        }

        String sql = "SELECT * FROM book Where 1=1";

        if (name != null && !name.isBlank()) {
            sql += " AND name = ?";
        }
        if (author != null && !author.isBlank()) {
            sql += " AND author = ?";
        }

        try {
            preparedStatement = conn.prepareStatement(sql);

            int index = 1;
            if (name != null && !name.isBlank()) {
                preparedStatement.setString(index++, name);
            }
            if (author != null && !author.isBlank()) {
                preparedStatement.setString(index, author);
            }

            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                Book book = new Book();
                book.setName(rs.getString("name"));
                book.setPrice(rs.getInt("price"));
                book.setAuthor(rs.getString("author"));

                request.setAttribute("book", book);
                request.getRequestDispatcher("/book.jsp").forward(request, response);
            } else {
                response.sendRedirect("/bookNotFound.jsp");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    public void initializeJDBC() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded");

            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/KaydenceDB", "Kaydence", "password");
            System.out.println("DB Connected");

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}