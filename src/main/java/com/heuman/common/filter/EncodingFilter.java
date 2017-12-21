package com.heuman.common.filter;

import org.apache.commons.lang3.StringUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.regex.Pattern;

/**
 * Created by heuman on 2017/10/18.
 */
public class EncodingFilter implements Filter {
    private Pattern excludePattern = null;
    private String encoding;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        encoding = filterConfig.getInitParameter("encoding");
        String excludeSuffix = filterConfig.getInitParameter("excludeSuffix");
        if (StringUtils.isNotBlank(excludeSuffix)) {
            excludePattern = Pattern.compile(".*\\.(" + excludeSuffix + ")");
        }
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        if (StringUtils.isNotBlank(encoding)) {
            if (excludePattern == null || !excludePattern.matcher(((HttpServletRequest) request).getRequestURI()).matches()) {
                request.setCharacterEncoding(encoding);
                response.setCharacterEncoding(encoding);
            }
        }
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
