package ru.geekbrains.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

//@WebFilter(urlPatterns = "/*")
public class BuilderHTMLFilter implements Filter {

    private transient FilterConfig filterConfig;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        this.filterConfig.getServletContext().getRequestDispatcher("/html/common/header.html").include(servletRequest, servletResponse);
        this.filterConfig.getServletContext().getRequestDispatcher("/html/common/menu.html").include(servletRequest, servletResponse);
        filterChain.doFilter(servletRequest, servletResponse);
        this.filterConfig.getServletContext().getRequestDispatcher("/html/common/footer.html").include(servletRequest, servletResponse);
    }
}
