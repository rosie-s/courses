package com.myapp.servlet;

import com.myapp.dao.LoginDao;
import com.myapp.model.Login;
import com.myapp.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(value = "/login")
public class LoginServlet extends HttpServlet {
    LoginDao loginDao = new LoginDao();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String actionParam = request.getParameter("action");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        Login login = new Login(email, password);

        if (actionParam.equals("add")) {
            loginDao.addLogin(login);
            response.sendRedirect(request.getContextPath() + "/login?action=list");
        } else if (actionParam.equals("login")) {
            if (loginDao.inDB(email, password)) {
                HttpSession session = request.getSession();
                session.setAttribute("login", loginDao.findLogin(email));
                response.sendRedirect(request.getContextPath() + "/login?action=list");
            } else {
                response.sendRedirect(request.getContextPath() + "/error?detail=wrongPassword");
            }
        } else {
            response.sendRedirect(request.getContextPath() + "/error?detail=errorPost");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        String actionParam = request.getParameter("action");

        if (actionParam.equals("add")) {
            request.getRequestDispatcher("/WEB-INF/pages/LoginAdd.jsp").forward(request, response);
        } else if (actionParam.equals("remove")) {
            String key = request.getParameter("key");
            loginDao.removeLogin(key);
            response.sendRedirect(request.getContextPath() + "/login?action=list");
        } else if (actionParam.equals("list")) {
            request.setAttribute("loginList", loginDao.returnLoginList());
            request.getRequestDispatcher("/WEB-INF/pages/LoginList.jsp").forward(request, response);
        } else if (actionParam.equals("logout")) {
            HttpSession session = request.getSession();
            session.invalidate();
            response.sendRedirect(request.getContextPath() + "/error?detail=loginPlease");
            response.getWriter().append("Log in Please");
        } else {
            response.sendRedirect(request.getContextPath() + "/error?detail=errorGet");
        }

    }
}
