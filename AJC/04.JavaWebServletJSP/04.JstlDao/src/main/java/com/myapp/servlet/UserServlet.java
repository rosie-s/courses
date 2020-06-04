package com.myapp.servlet;

import com.myapp.dao.UserDao;
import com.myapp.model.User;

import javax.servlet.annotation.WebServlet;
import java.io.IOException;

@WebServlet(value = "/userdetail")
public class UserServlet extends javax.servlet.http.HttpServlet {
    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

        String idParam =  request.getParameter("id");

        UserDao userDao = new UserDao();
        User u = userDao.findUser(idParam);

        request.setAttribute("user", u);
        request.getRequestDispatcher("/WEB-INF/pages/showUser.jsp").forward(request, response);
    }
}
