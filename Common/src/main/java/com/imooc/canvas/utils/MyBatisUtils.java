package com.imooc.canvas.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

/**
 * MyBatisUtils工具类
 * @version 1.0
 */
public class MyBatisUtils {
    //创建内部的私有变量
    private static SqlSessionFactory sqlSessionFactory;
    private static Reader reader;
    //使用静态代码块初始化sqlsessionfactory
    static {
        try {
            String RESOURCE="mybatis-config.xml";
            reader=Resources.getResourceAsReader(RESOURCE);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //获得sqlsession
    public static SqlSession openSession(){
        return sqlSessionFactory.openSession();
    }
}
