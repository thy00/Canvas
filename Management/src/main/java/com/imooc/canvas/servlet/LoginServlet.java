package com.imooc.canvas.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //没有设计用户的数据库，所以用户名和密码不为空且相同模拟登录
        if("/login.do".equals(request.getServletPath())){
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            //对用户名和密码进行判断
            if(username.equals(password)&&null!=password&&!"".equals(username.trim())){
                request.getSession().setAttribute("username",username);
                Cookie cookie = new Cookie("username",username);//本地保存登录会话
                cookie.setPath("/*");
                cookie.setMaxAge(30*60);
                response.addCookie(cookie);
                request.getRequestDispatcher("/canvas/list.do").forward(request,response);//转发到列表页
            }else{
                request.getRequestDispatcher("/loginPrompt.do").forward(request,response);//转发到登录页面
            }
        }else if ("/loginPrompt.do".equals(request.getServletPath())){
            request.getSession().removeAttribute("username");
            request.getRequestDispatcher("/WEB-INF/views/biz/login.jsp").forward(request,response);//转发到jsp登录页面
        }

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}