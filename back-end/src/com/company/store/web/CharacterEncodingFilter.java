package com.company.store.web;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

public class CharacterEncodingFilter implements Filter {
    private String encoding;

    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        if(encoding != null){
            req.setCharacterEncoding(encoding);
        }
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {
        encoding = config.getInitParameter("encoding");
    }

}
