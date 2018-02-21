package com.showCars;


import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet
        (name = "showCars",
                urlPatterns = {"/showCars"})
public class ServletShowCars extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        response.setContentType("text/html;charset=UTF-8");
//        //List<Car> cars = Dao.getDAO().getAll();
//        //response.getWriter().println(cars);
//        PrintWriter out = response.getWriter();
//        out.println("<html>");
//        out.println("<body>");
//        out.println("<h1>Hello Servlet Get</h1>");
//        out.println("</body>");
//        out.println("</html>");
//        out.close();
        ServletOutputStream out = response.getOutputStream();
        out.write("hello heroku".getBytes());
        out.flush();
        out.close();
//        RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/responseServlet.jsp");
//        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //List<Car> cars = Dao.getDAO().getAll();
        //response.getWriter().println(cars);
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<body>");
        out.println("<h1>Hello Servlet Get</h1>");
        out.println("</body>");
        out.println("</html>");
//        RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/responseServlet.jsp");
//        dispatcher.forward(request, response);
    }

    @Override
    public void init() throws ServletException {
        System.out.println("Servlet " + this.getServletName() + " has started");
    }

    @Override
    public void destroy() {
        System.out.println("Servlet " + this.getServletName() + " has stopped");
    }
}
