package com.yrxc.horse.controller;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@ControllerAdvice
public class MyAdviseController {

 public static final Logger logger = LoggerFactory.getLogger(MyAdviseController.class);
    public void output(Object json, HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        String header =request.getHeader("Origial");
        response.setContentType("application/json;charset=UTF-8;");
        PrintWriter out = response.getWriter();
        out.println(json);
        out.flush();
        out.close();
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    public void notFountHandler(HttpServletRequest request, HttpServletResponse response, NoHandlerFoundException e) throws IOException, JSONException {

        JSONObject json = new JSONObject();

        json.put("code", 500);

        json.put("content", null);

        json.put("msg", "未找到路径："+request.getServletPath());

        output(json,request,response);
        logger.info(request.getServletPath());

    }
    @ExceptionHandler({RuntimeException.class})
    @ResponseStatus(HttpStatus.OK)
    public ModelAndView  processException(HttpServletRequest request, HttpServletResponse response, RuntimeException exception) throws JSONException, IOException {

        JSONObject json = new JSONObject();
        json.put("code", 500);
        json.put("content", null);
        json.put("msg", exception.getMessage());
        output(json,request,response);
        logger.info(exception.getMessage());
        ModelAndView model = new ModelAndView();
        model.setViewName("error");
        model.addObject("object",json);
        return  model;
    }
    @ExceptionHandler({Exception.class})
    @ResponseStatus(HttpStatus.OK)
    public void  processException(HttpServletRequest request, HttpServletResponse response, Exception exception) throws JSONException, IOException {

        JSONObject json = new JSONObject();

        json.put("code", 500);

        json.put("content", null);

        json.put("msg", exception.getMessage());
        logger.info(exception.getMessage());
        output(json,request,response);

    }

}
