package com.wind.boot.config.filter;


import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Title: CrossFilter
 * @Package com.wind.webapi.filter
 * @Description: 跨域设置过滤器，由于SpringShiroFilter的顺序为1，此处为确保跨域设置以及i18n正确配置，将顺序设置为0
 * @author wind
 * @date 2018/9/17 17:41
 * @version V1.0
 */
@Component
@Order(0)
public class CrossFilter extends OncePerRequestFilter {

    private final String PARAM_NAME = "lang";

    private final String IGNORE_METHOD = "OPTIONS";

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        response.addHeader("Access-Control-Allow-Origin", "*");
        response.addHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS, PUT, DELETE");
        response.addHeader("Access-Control-Max-Age", "100");
        response.addHeader("Access-Control-Allow-Headers", "Content-Type,X-API-TOKEN");
        response.addHeader("Access-Control-Allow-Credentials", "false");
        response.addHeader("Access-Control-Expose-Headers", "X-API-TOKEN");

        // 非简单请求跨域，请求方法为OPTIONS，直接返回200状态码
        if(IGNORE_METHOD.equalsIgnoreCase(request.getMethod())){
            response.setStatus(HttpServletResponse.SC_OK);
            return;
        }

        filterChain.doFilter(request, response);
    }

}
