package ru.geekbrains;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

@WebServlet(name = "FirstServlet", urlPatterns = "/first_servlet")
public class FirstServlet implements Servlet {

    private static Logger logger = LoggerFactory.getLogger(FirstServlet.class);

    private transient ServletConfig config;

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        this.config = config;
    }

    @Override
    public ServletConfig getServletConfig() {
        return this.config;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        logger.info("New request");

        servletResponse.getWriter().println("<h1>Servlet content</h1>");
    }

    @Override
    public String getServletInfo() {
        return "FirstServlet";
    }

    @Override
    public void destroy() {
        logger.info("Servlet {} destroyed", getServletInfo());
    }
}
