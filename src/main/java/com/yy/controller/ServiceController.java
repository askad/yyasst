package com.yy.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.xml.sax.SAXException;

import com.yy.common.SecurityCode;

public class ServiceController extends HttpServlet {

    public static final String TOKEN = "askadyy";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {

        InputStream is = request.getInputStream();
        OutputStream os = response.getOutputStream();
        // 根据MsgType执行不同的handler
        MsgHub msgHandler = new MsgHub();
        try {
            msgHandler.onExec(is, os);
        } catch (SAXException e) {
            e.printStackTrace();
        }
        close(is, os);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String signature = request.getParameter("signature");// 微信加密签名
        String timestamp = request.getParameter("timestamp");// 时间戳
        String nonce = request.getParameter("nonce");// 随机数
        String echostr = request.getParameter("echostr");// 随机字符串
        Writer out = response.getWriter();
        if (isBlank(signature) || isBlank(timestamp) || isBlank(nonce) || isBlank(echostr)) {
            out.write("WARNING...");
        } else {
            // 重写totring方法，得到三个参数的拼接字符串
            List<String> list = new ArrayList<String>(3) {
                private static final long serialVersionUID = 2621444383666420433L;

                public String toString() {
                    return this.get(0) + this.get(1) + this.get(2);
                }
            };
            list.add(TOKEN);
            list.add(timestamp);
            list.add(nonce);
            // 将token、timestamp、nonce三个参数进行字典序排序
            Collections.sort(list);
            // 将三个参数字符串拼接成一个字符串进行sha1加密
            String tmpStr = new SecurityCode().encode(list.toString(), SecurityCode.SHA_1);
            // 开发者获得加密后的字符串可与signature对比，标识该请求来源于微信
            if (signature.equals(tmpStr)) {
                out.write(echostr);// 请求验证成功，返回随机码
            } else {
                out.write("");
            }
        }
        out.flush();
        out.close();
    }

    private boolean isBlank(String text) {
        if (null == text) {
            return true;
        }
        if (text.isEmpty()) {
            return true;
        }
        if (text.trim().isEmpty()) {
            return true;
        }
        return false;
    }
    
    /**
     * 关闭
     * */
    public void close(InputStream is, OutputStream os) {
        try {
            if (is != null) {
                is.close();
            }
            if (os != null) {
                os.flush();
                os.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
