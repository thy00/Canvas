package com.imooc.canvas.servlet;

import com.imooc.canvas.entity.Canvas;
import com.imooc.canvas.entity.Category;
import com.imooc.canvas.service.CanvasService;
import com.imooc.canvas.service.CategoryService;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

/**
 * 油画的servlet
 */
public class CanvasServlet extends HttpServlet {
    private CanvasService canvasService;
    private CategoryService categoryService;
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if ("/canvas/list.do".equals(req.getServletPath())) {
            //查询
            String categoryIdStr = req.getParameter("categoryId");
            List<Canvas> canvases = null;
            if (categoryIdStr == null) {
                canvases = canvasService.getCanvases(1, 20);//由登录界面进入
            } else {
                Integer categoryId = Integer.valueOf(categoryIdStr);
                canvases = canvasService.getCanvasesByCategoryId(categoryId, 1, 20);//点击分类查询
            }
            List<Category> categories = categoryService.getCategory();
            req.setAttribute("canvases", canvases);
            req.setAttribute("categories", categories);
            req.getRequestDispatcher("/WEB-INF/views/biz/canvas_list.jsp").forward(req, resp);
        } else if ("/canvas/addPrompt.do".equals(req.getServletPath())) {
            //转跳进添加页面
            List<Category> categories = categoryService.getCategory();
            req.setAttribute("categories", categories);//分类下拉列表
            req.getRequestDispatcher("/WEB-INF/views/biz/add_canvas.jsp").forward(req, resp);
        } else if ("/canvas/add.do".equals(req.getServletPath())) {
            req.setCharacterEncoding("utf-8");
            //添加新的油画
            if (ServletFileUpload.isMultipartContent(req)) {
                try {
                    FileItemFactory factory = new DiskFileItemFactory();//文件上传工厂
                    ServletFileUpload upload = new ServletFileUpload(factory);//使用工厂
                    List<FileItem> fileItems = upload.parseRequest(req);//解析请求
                    //对结果集进行遍历
                    Iterator<FileItem> items = fileItems.iterator();
                    Canvas canvas = new Canvas();
                    while (items.hasNext()) {
                        FileItem item = items.next();
                        if (item.isFormField()) {//普通格式
                            //Integer categoryId, String name, String creator, Integer price,String description, String details
                            String name = item.getFieldName();
                            if ("categoryId".equals(name)) {
                                canvas.setCategoryId(Integer.valueOf(item.getString()));
                            } else if ("name".equals(name)) {
                                canvas.setName(item.getString("UTF-8"));
                            } else if ("creator".equals(name)) {
                                canvas.setCreator(item.getString("UTF-8"));
                            } else if ("price".equals(name)) {
                                canvas.setPrice(Integer.valueOf(item.getString()));
                            } else if ("description".equals(name)) {
                                canvas.setDescription(item.getString("UTF-8"));
                            } else if ("details".equals(name)) {
                                canvas.setDetails(item.getString("UTF-8"));
                            }
                        } else {//文件格式
                            // byte[] smallImg
                            canvas.setSmallImg(item.get());
                        }
                    }
                    canvasService.addCanvas(canvas);
                    req.getRequestDispatcher("/canvas/list.do").forward(req, resp);
                } catch (FileUploadException e) {
                    e.printStackTrace();
                }
            }

        } else if ("/canvas/del.do".equals(req.getServletPath())) {
            String idStr = req.getParameter("id");
            if (idStr != null) {
                Integer id = Integer.valueOf(idStr);
                canvasService.delCanvas(id);
                req.getRequestDispatcher("/canvas/list.do").forward(req, resp);
            }
        } else if ("/canvas/updatePrompt.do".equals(req.getServletPath())) {
            String idStr = req.getParameter("id");
            Canvas canvas = null;
            if (idStr != null && !"".equals(idStr.trim())) {
                Integer id = Integer.valueOf(idStr);
                canvas = canvasService.getCanvasById(id);
            }
            //转跳进修改页面
            List<Category> categories = categoryService.getCategory();
            req.setAttribute("canvas", canvas);
            req.setAttribute("categories", categories);//分类下拉列表
            req.getRequestDispatcher("/WEB-INF/views/biz/update_canvas.jsp").forward(req, resp);
        } else if ("/canvas/update.do".equals(req.getServletPath())) {
            req.setCharacterEncoding("utf-8");
            //更新新的油画
            if (ServletFileUpload.isMultipartContent(req)) {
                try {
                    FileItemFactory factory = new DiskFileItemFactory();//文件上传工厂
                    ServletFileUpload upload = new ServletFileUpload(factory);//使用工厂
                    List<FileItem> fileItems = upload.parseRequest(req);//解析请求
                    //对结果集进行遍历
                    Iterator<FileItem> items = fileItems.iterator();
                    Canvas canvas = new Canvas();
                    while (items.hasNext()) {
                        FileItem item = items.next();
                        if (item.isFormField()) {//普通格式
                            //Integer categoryId, String name, String creator, Integer price,String description, String details
                            String name = item.getFieldName();
                            if ("id".equals(name)){
                                canvas.setId(Integer.valueOf(item.getString()));
                            }else if ("categoryId".equals(name)) {
                                canvas.setCategoryId(Integer.valueOf(item.getString()));
                            } else if ("name".equals(name)) {
                                canvas.setName(item.getString("UTF-8"));
                            } else if ("creator".equals(name)) {
                                canvas.setCreator(item.getString("UTF-8"));
                            } else if ("price".equals(name)) {
                                canvas.setPrice(Integer.valueOf(item.getString()));
                            } else if ("description".equals(name)) {
                                canvas.setDescription(item.getString("UTF-8"));
                            } else if ("details".equals(name)) {
                                canvas.setDetails(item.getString("UTF-8"));
                            }
                        } else {//文件格式
                            // byte[] smallImg
                            canvas.setSmallImg(item.get());
                        }
                    }
                    canvasService.updateCanvas(canvas);
                    req.getRequestDispatcher("/canvas/list.do").forward(req, resp);
                } catch (FileUploadException e) {
                    e.printStackTrace();
                }
            }
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
