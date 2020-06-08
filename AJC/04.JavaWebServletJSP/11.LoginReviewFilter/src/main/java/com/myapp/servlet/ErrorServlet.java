package com.myapp.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(value = "/error")
public class ErrorServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String errorParam = request.getParameter("detail");

        if (errorParam.equals("wrongPassword")) {
            response.getWriter().println("<p style=\"color:green\">Login not found</p>");
            System.out.println("*** Login not found ***");
            request.getRequestDispatcher("/WEB-INF/pages/Error.jsp").forward(request, response);
        } else if (errorParam.equals("loginPlease")) {
            response.getWriter().println("<h1 style=\"color:green\">Please Log in</h1>");
            System.out.println("*** Please Log in ***");
            request.getRequestDispatcher("/WEB-INF/pages/Error.jsp").forward(request, response);
        } else if (errorParam.equals("errorPost")) {
            response.getWriter().println("<p style=\"color:green\">Problem with POST</p>");
            System.out.println("*** Problem with POST ***");
            request.getRequestDispatcher("/WEB-INF/pages/Error.jsp").forward(request, response);
        } else if (errorParam.equals("errorGet")) {
            response.getWriter().println("<p style=\"color:green\">Problem with GET</p>");
            System.out.println("*** Problem with GET ***");
            request.getRequestDispatcher("/WEB-INF/pages/Error.jsp").forward(request, response);
        } else if (errorParam.equals("filterError")) {
            response.getWriter().println("<p style=\"color:green\">Filter Error</p>");
            System.out.println("*** Filter Error ***");
            request.getRequestDispatcher("/WEB-INF/pages/Error.jsp").forward(request, response);
        } else if (errorParam.equals("user")) {
            System.out.println("*** User Error ***");
            request.getRequestDispatcher("/WEB-INF/pages/ErrorOld.jsp").forward(request, response);
        } else {
            response.getWriter().println("<p style=\"color:green\">ERROR!!!</p>");
            request.getRequestDispatcher("/WEB-INF/pages/Error.jsp").forward(request, response);
            System.out.println("*** ERROR ***");
        }

    }
}
