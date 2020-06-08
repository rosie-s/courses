package com.myapp.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        String path = ((HttpServletRequest) request).getRequestURI();
        if (path.contains("/error") || path.contains("login") && (request.getParameter("action") == null || request.getParameter("action").equals("login"))) {
            chain.doFilter(request, response);
        } else {
            if (request instanceof HttpServletRequest) {
                HttpSession session = ((HttpServletRequest) request).getSession();
                if (session.getAttribute("login") != null) {
                    chain.doFilter(request, response);
                } else {
                    ((HttpServletResponse) response).sendRedirect(((HttpServletRequest) request).getContextPath() + "/error?detail=filterError");
                }
            }
        }
    }

    @Override
    public void destroy() {

    }
}