package com.xzy_212306259.demo.Interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AuthInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String method = request.getMethod();
        String uri = request.getRequestURI();
        boolean isCreateUser = "POST".equalsIgnoreCase(method) && "/api/users".equalsIgnoreCase(uri);
        boolean isGetUser = "GET".equals(method) && uri.startsWith("/api/users");
        if(isCreateUser || isGetUser){
            return true;
        }
        
        String token = request.getHeader("Authorization");
        if(token == null || token.isEmpty()){
            response.setContentType("application/json;charset=utf-8");
            String errorJson = "{\"code\":401,\"msg\":\"未授权\"}";
            response.getWriter().write(errorJson);
            return false;
        }
        return true;
    }
}