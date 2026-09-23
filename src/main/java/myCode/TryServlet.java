package myCode;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name="TryServlet", value="/TryServlet")
public class TryServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        super.init();
        System.out.println("We are now calling service init...");
    }

    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.service(request, response);
        System.out.println("We are now calling service method...");
    }

    @Override
    public void destroy() {
        super.destroy();
        System.out.println("We are now calling destroy mothod...");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        收到GET request
        response .setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1> Try Servlet </h1>");
        out.println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

//    HTTP
//    GET request, POST request, PATCH, PUT, DELETE
}
