package com.imooc.canvas.mapper;

import com.imooc.canvas.entity.Canvas;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 蛋糕
 */
public interface CanvasMapper {
    /**
     * 分页查询油画
     * @param skip 跳过的条数
     * @param size 一次查询的条数
     * @return 油画集合
     */
    @Select("select * from canvas order by createTime desc limit #{skip},#{size}")
    List<Canvas> getCanvases(@Param("skip") Integer skip, @Param("size") Integer size);

    /**
     * 根据分类分页查询油画
     * @param categoryId 分类ID
     * @param skip 跳过的条数
     * @param size 一次查询的条数
     * @return 油画集合
     */
    @Select("select * from canvas where categoryId=#{categoryId} order by createTime desc limit #{skip},#{size}")
    List<Canvas> getCanvasesByCategoryId(@Param("categoryId") Integer categoryId,@Param("skip") Integer skip, @Param("size") Integer size);

    /**
     * 根据分类查询油画数量
     * @param categoryId 分类ID
     * @return 分类油画数量
     */
    @Select("select count(*) from canvas where categoryId=#{categoryId}")
    Integer countCanvasesByCategoryId(@Param("categoryId") Integer categoryId);

    /**
     * 查询油画数量
     * @return 油画数量
     */
    @Select("select count(*) from canvas")
    Integer countCanvases();

    /**
     * 根据id查询油画
     * @param id 油画ID
     * @return 油画实体
     */
    @Select("select * from canvas where id=#{id}")
    Canvas getCanvasById(@Param("id") Integer id);

    /**
     * 添加新的油画
     * @param canvas 油画实体
     */
    @Insert("insert into canvas(categoryId,name,creator,price,smallImg,createTime,updateTime,description,details) " +
            "values(#{canvas.categoryId},#{canvas.name},#{canvas.creator},#{canvas.price}," +
            "#{canvas.smallImg},#{canvas.createTime},#{canvas.updateTime},#{canvas.description},#{canvas.details})")
    void addCanvas(@Param("canvas") Canvas canvas);

    /**
     * 查询油画图片
     * @param id  油画ID
     * @return 只包含油画图片的实体
     */
    @Select("select smallImg from canvas where id=#{id}")
    Canvas getImg(@Param("id") Integer id);

    /**
     * 修改油画信息
     * @param canvas 油画实体
     */
    @Update("update canvas set categoryId=#{canvas.categoryId},name=#{canvas.name},creator=#{canvas.creator},price=#{canvas.price}," +
            "smallImg=#{canvas.smallImg},updateTime=#{canvas.updateTime},description=#{canvas.description},details=#{canvas.details} where id=#{canvas.id}")
    void updateCanvas(@Param("canvas") Canvas canvas);

    /**
     * 删除油画
     * @param id 油画ID
     */
    @Delete("delete from canvas where id = #{id}")
    void delCanvas(@Param("id") Integer id);


}
