package com.imooc.canvas.service;

import com.imooc.canvas.entity.Canvas;
import com.imooc.canvas.mapper.CanvasMapper;
import com.imooc.canvas.utils.MyBatisUtils;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.session.SqlSession;

import java.util.Date;
import java.util.List;

/**
 * 油画service
 */
public class CanvasService {
    /**
     * 分页查询油画
     * @param page 当前页面页数
     * @param size 一次查询的条数
     * @return 油画集合
     */
    public List<Canvas> getCanvases(Integer page,Integer size){
        SqlSession sqlSession=MyBatisUtils.openSession();
        try {
            CanvasMapper mapper = sqlSession.getMapper(CanvasMapper.class);
            List<Canvas> canvasesList = mapper.getCanvases((page - 1) * size, size);
            return canvasesList;
        } finally {
            sqlSession.close();
        }
    }

    /**
     * 根据分类分页查询油画
     * @param categoryId 分类ID
     * @param page 当前页面页数
     * @param size 一次查询的条数
     * @return 油画集合
     */
    public List<Canvas> getCanvasesByCategoryId(Integer categoryId, Integer page,Integer size){
        SqlSession sqlSession=MyBatisUtils.openSession();
        try {
            CanvasMapper mapper = sqlSession.getMapper(CanvasMapper.class);
            List<Canvas> canvasesList = mapper.getCanvasesByCategoryId(categoryId, (page - 1) * size, size);
            return canvasesList;
        } finally {
            sqlSession.close();
        }
    }

    /**
     * 根据分类查询油画数量
     * @param categoryId 分类ID
     * @return 分类油画页数
     */
    public Integer totalPageCanvasesByCategoryId(Integer categoryId){
        SqlSession sqlSession=MyBatisUtils.openSession();
        try {
            CanvasMapper mapper = sqlSession.getMapper(CanvasMapper.class);
            Integer count = mapper.countCanvasesByCategoryId(categoryId);
            Integer totalPage=count % 3 == 0 ? (count / 3) : ((count / 3) + 1);
            return totalPage;
        } finally {
            sqlSession.close();
        }
    }

    /**
     * 查询油画数量
     * @return 分类油画页数
     */
    public Integer totalPageCanvases(){
        SqlSession sqlSession=MyBatisUtils.openSession();
        try {
            CanvasMapper mapper = sqlSession.getMapper(CanvasMapper.class);
            Integer count = mapper.countCanvases();
            System.out.println("总条数"+count);
            Integer totalPage=count%3==0?(count/3):((count/3) + 1);
            return totalPage;
        } finally {
            sqlSession.close();
        }
    }

    /**
     * 根据id查询油画
     * @param id 油画ID
     * @return 油画实体
     */
    public Canvas getCanvasById(Integer id){
        SqlSession sqlSession=MyBatisUtils.openSession();
        try {
            CanvasMapper mapper = sqlSession.getMapper(CanvasMapper.class);
            Canvas canvas = mapper.getCanvasById(id);
            return canvas;
        } finally {
            sqlSession.close();
        }
    }

    /**
     * 添加新的油画
     * @param canvas 油画实体
     */
    public void addCanvas(Canvas canvas){
        Date date=new Date();
        canvas.setCreateTime(date);
        canvas.setUpdateTime(date);
        SqlSession sqlSession=MyBatisUtils.openSession();
        try {
            CanvasMapper mapper = sqlSession.getMapper(CanvasMapper.class);
             mapper.addCanvas(canvas);
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
    }

    /**
     * 查询油画图片
     * @param id  油画ID
     * @return 只包含油画图片的实体
     */
    public Canvas getImg(Integer id){
        SqlSession sqlSession=MyBatisUtils.openSession();
        try {
            CanvasMapper mapper = sqlSession.getMapper(CanvasMapper.class);
            Canvas imgCanvas = mapper.getImg(id);
            return imgCanvas;
        } finally {
            sqlSession.close();
        }
    }

    /**
     * 修改油画信息
     * @param canvas 油画实体
     */
    public void updateCanvas(Canvas canvas){
        Date date=new Date();
        canvas.setUpdateTime(date);
        SqlSession sqlSession=MyBatisUtils.openSession();
        try {
            CanvasMapper mapper = sqlSession.getMapper(CanvasMapper.class);
            mapper.updateCanvas(canvas);
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
    }

    /**
     * 删除油画
     * @param id 油画ID
     */
    public void delCanvas(Integer id){
        SqlSession sqlSession=MyBatisUtils.openSession();
        try {
            CanvasMapper mapper = sqlSession.getMapper(CanvasMapper.class);
            mapper.delCanvas(id);
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
    }
}
