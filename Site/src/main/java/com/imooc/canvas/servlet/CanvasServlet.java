package com.imooc.canvas.servlet;

import com.imooc.canvas.entity.Canvas;
import com.imooc.canvas.entity.Category;
import com.imooc.canvas.service.CanvasService;
import com.imooc.canvas.service.CategoryService;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * 网站的servlet
 */
public class CanvasServlet extends HttpServlet {
    private CanvasService canvasService;
    private CategoryService categoryService;
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if ("/canvas/list.do".equals(req.getServletPath())){
            /**
             * 从页面获得：当前页（没有的话赋值1），分类ID（没有的话不赋值）
             * 传递给页面：当前页，总页数，分类信息集合，油画信息集合，分类ID
             */
            String categoryIdStr = req.getParameter("categoryId");
            String pageStr = req.getParameter("page");
            Integer categoryId=null;
            Integer page=1;
            if (pageStr!=null&&!"".equals(pageStr.trim())){
                page= Integer.valueOf(pageStr);
                if (page==0){
                    page=1;
                }
            }
            Integer totalPage;
            List<Canvas> canvases = null;
            if (categoryIdStr == null||"".equals(categoryIdStr.trim())) {
                totalPage=canvasService.totalPageCanvases();
                canvases = canvasService.getCanvases(page, 3);//由主页进入
            } else {
                categoryId = Integer.valueOf(categoryIdStr);
                totalPage=canvasService.totalPageCanvasesByCategoryId(categoryId);
                canvases = canvasService.getCanvasesByCategoryId(categoryId, page, 3);//点击分类查询
            }
            List<Category> categories = categoryService.getCategory();
            System.out.println("总页数"+totalPage);
            req.setAttribute("categoryId",categoryId);//分类ID
            req.setAttribute("page", page);//当前页
            req.setAttribute("totalPage", totalPage);//总页数
            req.setAttribute("canvases", canvases);//油画信息集合
            req.setAttribute("categories", categories);//分类信息集合
            req.getRequestDispatcher("/WEB-INF/views/biz/index.jsp").forward(req, resp);
        }else if ("/canvas/getImg.do".equals(req.getServletPath())){
            /**
             * 从页面获得：油画ID
             * 传递给页面：图片的字节流
             */
            Integer id = Integer.valueOf(req.getParameter("id"));
            Canvas img = canvasService.getImg(id);
            //从实体中读出图片，写入响应中
            try {
                resp.setContentType("multipart/form-data");
                if(id!=null&&img.getSmallImg()!=null){
                    InputStream in= new ByteArrayInputStream(img.getSmallImg());
                    ServletOutputStream out=resp.getOutputStream();
                    byte[] bytes=new byte[1024];
                    int length=in.read(bytes);
                    while (length!=-1){
                        out.write(bytes);
                        length=in.read(bytes);
                    }
                    out.flush();
                    out.close();
                    in.close();
                    resp.flushBuffer();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else if ("/canvas/detail.do".equals(req.getServletPath())){
            /**
             * 从页面中获取：ID
             * 传递给页面：油画实体
             */
            Integer id = Integer.valueOf(req.getParameter("id"));
            Canvas canvas = canvasService.getCanvasById(id);
            req.setAttribute("canvas",canvas);
            req.getRequestDispatcher("/WEB-INF/views/biz/detail.jsp").forward(req,resp);
        }
    }

    @Override
    public void destroy() {
        super.destroy();
        canvasService=null;
        categoryService=null;

    }

    @Override
    public void init() throws ServletException {
        super.init();
        canvasService=new CanvasService();
        categoryService=new CategoryService();
    }
}
