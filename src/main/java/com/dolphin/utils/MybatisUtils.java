package com.dolphin.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * 该工具特点
 * Mybatis 不用频繁启动
 * ThreadLocal 保证了在这一次的启动中，获得SqlSession 是一个
 *
 */
public class MybatisUtils {
    //1、定义ThreadLoacl
    private static ThreadLocal<SqlSession> threadLocal = new ThreadLocal<>();
    //2、初始化SqlSessionFactory
    private static SqlSessionFactory sqlSessionFactory = null;
    static {
        //创建SqlSessionFactory
        InputStream is = null;
         try {
            is = Resources.getResourceAsStream("mybatis-cfg.xml");
         } catch (IOException e) {
            e.printStackTrace();
         }
         sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
    }
    // 获取SqlSession
    public static SqlSession getSqlSession(){
        SqlSession sqlSession = threadLocal.get();
        if (sqlSession == null){
            sqlSession = sqlSessionFactory.openSession();
            threadLocal.set(sqlSession);
        }
        return sqlSession;
    }
    // 关闭SqlSession
    public static void closeSqlSession(){
        SqlSession sqlSession = threadLocal.get();
        if (sqlSession!=null){
            sqlSession.close();
            //置空，清空缓存
            threadLocal.set(null);
        }
    }
}
