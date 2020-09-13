package ru.geekbrains.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(urlPatterns = "/*")
public class BuilderHTMLFilter implements Filter {

    private transient FilterConfig filterConfig;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        filterConfig.getServletContext().getRequestDispatcher("/html/common/header.html").include(req, resp);
        filterConfig.getServletContext().getRequestDispatcher("/html/common/menu.html").include(req, resp);
        chain.doFilter(req, resp);
        filterConfig.getServletContext().getRequestDispatcher("/html/common/footer.html").include(req, resp);
    }
}
