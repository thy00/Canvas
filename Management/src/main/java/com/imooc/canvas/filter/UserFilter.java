package com.imooc.canvas.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class UserFilter implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        //分别对登录以及非登录判断，是否需要转跳登录界面
        HttpServletRequest req=(HttpServletRequest)request;
        if("/login.do".equals(req.getServletPath())||"/loginPrompt.do".equals(req.getServletPath())){
            chain.doFilter(request,response);//放行
        }else if (null!=req.getSession().getAttribute("username")){
            chain.doFilter(request,response);//放行
        }else {
            request.getRequestDispatcher("/loginPrompt.do").forward(request,response);//转发到登录页面
        }
    }

    public void destroy() {
    }
}
