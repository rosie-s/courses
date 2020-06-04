package com.myapp.servlet;

import javax.servlet.annotation.WebServlet;
import java.io.IOException;

@WebServlet(value = "/userdetail")
public class UserServlet extends javax.servlet.http.HttpServlet {
    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        request.setAttribute("name", "Rosie");
        ;request.getRequestDispatcher("/WEB-INF/pages/showUser.jsp").forward(request, response);
    }
}
