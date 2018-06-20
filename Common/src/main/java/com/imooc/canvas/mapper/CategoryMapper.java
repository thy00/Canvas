package com.imooc.canvas.mapper;

import com.imooc.canvas.entity.Category;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 油画分类
 */
public interface CategoryMapper {

    /**
     * 添加分类
     * @param category 分类实体
     */
    @Insert("insert into category(name,createName,createTime,updateTime,description) " +
            "values (#{category.name},#{category.createName},#{category.createTime},#{category.updateTime},#{category.description})")
    void addCategory(@Param("category") Category category);

    /**
     * 删除分类
     * @param id 分类ID
     */
    @Delete("delete from category where id = #{id}")
    void delCategory(@Param("id") Integer id);

    /**
     * 修改分类
     * @param category 分类实体
     */
    @Update("update category set name=#{category.name},createName=#{category.createName}" +
            ",updateTime=#{category.updateTime},description=#{category.description} where id=#{category.id}")
    void updateCategory(@Param("category") Category category);

    /**
     * 查询全部分类
     * @return 分类集合
     */
    @Select("select * from category")
    List<Category> getCategory();

    /**
     * 根据ID查询分类
     * @return 分类
     */
    @Select("select * from category where id =#{id}")
    Category getCategoryById(@Param("id") Integer id);
}
