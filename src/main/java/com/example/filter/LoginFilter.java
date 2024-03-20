package com.example.filter;

import com.example.pojo.Result;
import com.example.utils.JwtUtils;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
//@WebFilter(urlPatterns = "/*")
public class LoginFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String url = request.getRequestURI();
        log.info("请求的url: " + url);

        if (url.contains("login")) {
            log.info("登陆操作");
            filterChain.doFilter(request, response);
            return;
        }

        String jwt = request.getHeader("token");

        if (jwt == null || jwt.length() == 0) {
            log.info("jwt为空");
            Result error = Result.error("NOT_LOGIN");
            response.getWriter().write(new Gson().toJson(error));
            return;
        }

        try {
            JwtUtils.parseJwt(jwt);
        } catch (Exception e) {
            e.printStackTrace();
            log.info("解析令牌失败");
            Result error = Result.error("NOT_LOGIN");
            response.getWriter().write(new Gson().toJson(error));
            return;
        }

        log.info("令牌合法");
        filterChain.doFilter(request, response);
    }
}
