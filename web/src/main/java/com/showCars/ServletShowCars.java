package com.showCars;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ServletShowCars extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //List<Car> cars = Dao.getDAO().getAll();
        //response.getWriter().println(cars);
//        response.getWriter().println("Yep");
        RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/responseServlet.jsp");
        dispatcher.forward(request, response);
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
