package com.myapp.servlet;

import com.myapp.dao.UserDao;
import com.myapp.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(value = "/user")
public class UserServlet extends javax.servlet.http.HttpServlet {
    UserDao userDao = new UserDao();

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

        String idParam = request.getParameter("action");

        if (idParam.equals("list")) {
            request.setAttribute("myList", userDao.returnUserList2());
            request.getRequestDispatcher("/WEB-INF/pages/UserList.jsp").forward(request, response);
        } else if (idParam.equals("detail")) {
            idParam = request.getParameter("id");
            request.setAttribute("user", userDao.findUser(idParam));
            request.getRequestDispatcher("/WEB-INF/pages/UserDetail.jsp").forward(request, response);
        } else if (idParam.equals("add")) {
            request.setAttribute("postUserUrl", "/thebadurl");
            request.getRequestDispatcher("/WEB-INF/pages/UserAdd.jsp").forward(request, response);
            request.getServletContext().setAttribute("postUserUrl", request.getServletContext().getInitParameter("postUserUrl"));
        } else if (idParam.equals("createsession")) {
            HttpSession session = request.getSession();
            session.setAttribute("user", "rosie");
            request.getRequestDispatcher("/WEB-INF/pages/UserAdd.jsp").forward(request, response);
        } else if (idParam.equals("resetsession")) {
            HttpSession session = request.getSession();
            session.invalidate();
            request.getRequestDispatcher("/WEB-INF/pages/UserAdd.jsp").forward(request, response);
        } else {
            //Error
            //response.sendRedirect("error");
            response.sendRedirect(request.getContextPath() + "/error?detail=user");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Hello from post" + req.getParameter("name"));
        resp.getWriter().append("Hello from POST " + req.getParameter("name") + " " + req.getParameter("surname") + "\n Your salary is: " + req.getParameter("salary"));

        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        String salary = req.getParameter("salary");
        User user = new User(name, surname, Double.parseDouble(salary));

        userDao.addUser(user);

        resp.sendRedirect("user?action=list");
    }
}
