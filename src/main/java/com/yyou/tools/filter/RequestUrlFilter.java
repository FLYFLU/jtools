package com.yyou.tools.filter;

import com.alibaba.druid.util.PatternMatcher;
import com.alibaba.druid.util.ServletPathMatcher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class RequestUrlFilter implements Filter {

    private static final Logger logger = LoggerFactory.getLogger(RequestUrlFilter.class);
    private Set<String> excludesPattern;
    PatternMatcher pathMatcher = new ServletPathMatcher();

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        String param = filterConfig.getInitParameter("exclusions");
        if (param != null && param.trim().length() != 0) {
            this.excludesPattern = new HashSet<>(Arrays.asList(param.split("\\s*,\\s*")));
        }
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String uri = ((HttpServletRequest) servletRequest).getRequestURI();
        if (!this.isExclusion(uri)) {
            logger.info(uri);
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }

    private boolean isExclusion(String requestURI) {
        if (this.excludesPattern != null && requestURI != null) {

            Iterator<String> var2 = this.excludesPattern.iterator();

            String pattern;
            do {
                if (!var2.hasNext()) {
                    return false;
                }
                pattern = var2.next();
            } while (!this.pathMatcher.matches(pattern, requestURI));

            return true;
        } else {
            return false;
        }
    }
}
