package com.myapp.servlet;

import com.myapp.dao.UserDao;
import com.myapp.model.User;

import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@WebServlet(value = "/user")
public class UserServlet extends javax.servlet.http.HttpServlet {
    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

        UserDao userDao = new UserDao();
        String idParam = request.getParameter("action");

        if (idParam.equals("list")){
            request.setAttribute("myList", userDao.returnUserList2());
            request.getRequestDispatcher("/WEB-INF/pages/UserList.jsp").forward(request, response);
        }
        else {
            idParam = request.getParameter("id");

            request.setAttribute("user", userDao.findUser(idParam));
            request.getRequestDispatcher("/WEB-INF/pages/UserDetail.jsp").forward(request, response);
        }
    }
}
