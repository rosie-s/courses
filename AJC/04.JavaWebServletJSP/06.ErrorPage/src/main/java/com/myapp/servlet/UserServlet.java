package com.myapp.servlet;

import com.myapp.dao.UserDao;

import javax.servlet.annotation.WebServlet;
import java.io.IOException;

@WebServlet(value = "/user")
public class UserServlet extends javax.servlet.http.HttpServlet {
    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

        UserDao userDao = new UserDao();
        String idParam = request.getParameter("action");

        if (idParam.equals("list")) {
            request.setAttribute("myList", userDao.returnUserList2());
            request.getRequestDispatcher("/WEB-INF/pages/UserList.jsp").forward(request, response);
        } else if (idParam.equals("detail")) {
            idParam = request.getParameter("id");
            request.setAttribute("user", userDao.findUser(idParam));
            request.getRequestDispatcher("/WEB-INF/pages/UserDetail.jsp").forward(request, response);
        } else {
            //Error
            //response.sendRedirect("error");
            response.sendRedirect(request.getContextPath() + "/error");
        }
    }
}
