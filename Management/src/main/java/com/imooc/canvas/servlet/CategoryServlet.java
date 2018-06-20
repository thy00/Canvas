package com.imooc.canvas.servlet;

import com.imooc.canvas.entity.Category;
import com.imooc.canvas.service.CategoryService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 分类的servlet
 */
public class CategoryServlet extends HttpServlet {
    private CategoryService categoryService;
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if("/category/list.do".equals(req.getServletPath())){
            List<Category> categories = categoryService.getCategory();
            req.setAttribute("categories",categories);
            req.getRequestDispatcher("/WEB-INF/views/biz/category_list.jsp").forward(req,resp);
        }else if ("/category/addPrompt.do".equals(req.getServletPath())){
            req.getRequestDispatcher("/WEB-INF/views/biz/add_category.jsp").forward(req,resp);
        }else if ("/category/add.do".equals(req.getServletPath())){
            req.setCharacterEncoding("utf-8");
            //String name,String createName,String description
            String name = req.getParameter("name");
            String createName = req.getParameter("createName");
            String description = req.getParameter("description");
            Category category=new Category();
            category.setName(name);
            category.setCreateName(createName);
            category.setDescription(description);
            categoryService.addCategory(category);
            req.getRequestDispatcher("/category/list.do").forward(req,resp);
        }else if ("/category/del.do".equals(req.getServletPath())) {
            String idStr = req.getParameter("id");
            if (idStr != null) {
                Integer id = Integer.valueOf(idStr);
                categoryService.delCategory(id);
                req.getRequestDispatcher("/category/list.do").forward(req, resp);
            }
        }else if ("/category/updatePrompt.do".equals(req.getServletPath())) {
            String idStr = req.getParameter("id");
            if (idStr != null) {
                Integer id = Integer.valueOf(idStr);
                Category category = categoryService.getCategoryById(id);
                req.setAttribute("category",category);
                req.getRequestDispatcher("/WEB-INF/views/biz/update_category.jsp").forward(req, resp);
            }
        }else if ("/category/update.do".equals(req.getServletPath())) {
            req.setCharacterEncoding("utf-8");
            // Integer id,String name,String createName,String description
            Integer id = Integer.valueOf(req.getParameter("id"));
            String name = req.getParameter("name");
            String createName = req.getParameter("createName");
            String description = req.getParameter("description");
            Category category=new Category();
            category.setId(id);
            category.setName(name);
            category.setCreateName(createName);
            category.setDescription(description);
            categoryService.updateCategory(category);
            req.getRequestDispatcher("/category/list.do").forward(req,resp);
        }
    }

    @Override
    public void destroy() {
        super.destroy();
        categoryService=null;
    }

    @Override
    public void init() throws ServletException {
        super.init();
        categoryService=new CategoryService();
    }
}
