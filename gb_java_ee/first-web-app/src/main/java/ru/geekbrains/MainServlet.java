package ru.geekbrains;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "MainServlet", urlPatterns = "/main/*")
public class MainServlet extends HttpServlet {

    private static Logger logger = LoggerFactory.getLogger(MainServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("New GET request to MainServlet");

        resp.getWriter().println("<h1>Main</h1>");
        resp.getWriter().println("<p>ПРИВЕТ</p>");
        resp.getWriter().println("<p> contextPath = " + req.getContextPath() + "</p>");
        resp.getWriter().println("<p> servletPath = " + req.getServletPath() + "</p>");
        resp.getWriter().println("<p> pathInfo = " + req.getPathInfo() + "</p>");
        resp.getWriter().println("<p> queryString = " + req.getQueryString() + "</p>");

    }
}