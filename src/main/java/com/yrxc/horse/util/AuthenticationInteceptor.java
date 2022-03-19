package com.yrxc.horse.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.yrxc.horse.entity.Login;

import com.yrxc.horse.service.LoginService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.util.Map;

public class AuthenticationInteceptor implements HandlerInterceptor {

    @Autowired
    LoginService loginService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("token");
        if(!(handler instanceof HandlerMethod))
        {
            return true;
        }
        HandlerMethod handlerMethod =(HandlerMethod)handler;

        Method method=handlerMethod.getMethod();
        if(method.isAnnotationPresent(PassToken.class))
        {
            PassToken passToken =method.getAnnotation(PassToken.class);
            if(passToken.required())
            {
                return true;
            }
        }
        if(method.isAnnotationPresent(UserLoginToken.class))
        {
            UserLoginToken userLoginToken=method.getAnnotation(UserLoginToken.class);
            if(userLoginToken.required())
            {
                if(token == null)
                {
                    throw new RuntimeException("无token,请先完成登录!");
                }
                String Id;
                try{
                    Id = JWT.decode(token).getAudience().get(0);
                }catch (JWTDecodeException j){
                    throw new RuntimeException("401");
                }
                Login log=loginService.selectById(Long.valueOf(Id));
                if(log == null)
                {
                    throw new RuntimeException("用户不存在!");
                }
                JWTVerifier jwtVerifier=JWT.require(Algorithm.HMAC256(log.getScode())).build();
                try{
                    jwtVerifier.verify(token);
                }catch (JWTVerificationException k){
                    throw new RuntimeException("用户token已经过期，请重新登录！");
                }
                return true;
            }
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }

    private void returnJson(HttpServletResponse response) {

        PrintWriter writer = null;

        response.setCharacterEncoding("UTF-8");

        response.setContentType("application/json; charset=utf-8");

        try {
            writer = response.getWriter();
            writer.write("<h1>用户令牌token无效!请重新登录!");
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            if (writer != null) {
                writer.close();
            }
        }
    }

}
