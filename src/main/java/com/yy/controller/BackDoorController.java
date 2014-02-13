package com.yy.controller;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import yy.weibo.service.WeiboTrafficService;

public class BackDoorController extends HttpServlet {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    public static final String TOKEN = "askadyy";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        WeiboTrafficService wts = new WeiboTrafficService(true);
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charSet=UtF-8");
        Writer out = response.getWriter();
        out.write(wts.getTextFromSc());
        out.flush();
        out.close();
    }

}
