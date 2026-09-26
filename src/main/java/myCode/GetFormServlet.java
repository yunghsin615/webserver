package myCode;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name="GetFormServlet", value="/GetFormServlet")
public class GetFormServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request,  HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        // GET params form get request
        String bookName = request.getParameter("name");
        String price = request.getParameter("price");
        String author = request.getParameter("author");

        PrintWriter out = response.getWriter();
        out.println("<h2>" + bookName + "</h2>");
        out.println("<h4>price: " + price + "</h4>");
        out.println("<h4>author: " + author + "</h4>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
