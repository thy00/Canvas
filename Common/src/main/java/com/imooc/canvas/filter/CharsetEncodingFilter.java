package com.imooc.canvas.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * 字符集过滤器
 */
public class CharsetEncodingFilter implements Filter {

    //设置String接收编码类型
    private static String encoding;
    public void init(FilterConfig filterConfig) throws ServletException {
        //设置初始化参数
        this.encoding = filterConfig.getInitParameter("encoding");
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        //设置编码方式
        request.setCharacterEncoding(encoding);
        //放行
        chain.doFilter(request,response);
    }

    public void destroy() {
    }
}
