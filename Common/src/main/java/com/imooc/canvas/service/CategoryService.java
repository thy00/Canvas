package com.imooc.canvas.service;

import com.imooc.canvas.entity.Category;
import com.imooc.canvas.mapper.CategoryMapper;
import com.imooc.canvas.utils.MyBatisUtils;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.session.SqlSession;

import java.util.Date;
import java.util.List;

/**
 * 分类service
 */
public class CategoryService {
    /**
     * 添加分类
     * @param category 分类实体
     */
    public void addCategory(Category category){
        Date date=new Date();
        category.setCreateTime(date);
        category.setUpdateTime(date);
//        System.out.println("分类的信息是"+category.toString());
        SqlSession sqlSession = MyBatisUtils.openSession();
        try {
            CategoryMapper mapper = sqlSession.getMapper(CategoryMapper.class);
            mapper.addCategory(category);
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
    }

    /**
     * 删除分类
     * @param id 分类ID
     */
    public void delCategory(Integer id){
        SqlSession sqlSession = MyBatisUtils.openSession();
        try {
            CategoryMapper mapper = sqlSession.getMapper(CategoryMapper.class);
            mapper.delCategory(id);
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
    }

    /**
     * 修改分类
     * @param category 分类实体
     */
    public void updateCategory(Category category){
        Date date=new Date();
        category.setUpdateTime(date);
        SqlSession sqlSession = MyBatisUtils.openSession();
        try {
            CategoryMapper mapper = sqlSession.getMapper(CategoryMapper.class);
            mapper.updateCategory(category);
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
    }

    /**
     * 查询全部分类
     * @return 分类集合
     */
    public List<Category> getCategory(){
        SqlSession sqlSession = MyBatisUtils.openSession();
        try {
            CategoryMapper mapper = sqlSession.getMapper(CategoryMapper.class);
            List<Category> categoriesList = mapper.getCategory();
            return categoriesList;
        } finally {
            sqlSession.close();
        }
    }

    /**
     * 根据ID查询分类
     * @return 分类
     */
    public Category getCategoryById(Integer id){
        SqlSession sqlSession = MyBatisUtils.openSession();
        try {
            CategoryMapper mapper = sqlSession.getMapper(CategoryMapper.class);
            Category category = mapper.getCategoryById(id);
            return category;
        } finally {
            sqlSession.close();
        }
    }
}
