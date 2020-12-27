package com.dolphin.dao.impl;

import com.dolphin.dao.UserDao;
import com.dolphin.pojo.Users;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class UserDaoImpl implements UserDao {
    /**
     * 查询所有用户
     * @return
     */
    @Override
    public List<Users> selectUsersAll()throws IOException {
        //创建SqlSessionFactory对象
        InputStream inputStream = Resources.getResourceAsStream("mybatis-cfg.xml");
        SqlSessionFactory sqlSessionFacotry = new SqlSessionFactoryBuilder().build(inputStream);
        //获取SqlSession对象
        SqlSession sqlSession = sqlSessionFacotry.openSession();
        //通过SqlSession对象下的API完成对数据库的操作
        List<Users> list = sqlSession.selectList("com.dolphin.mapper.UsersMapper.selectUsersAll");
        //关闭SqlSession对象
        sqlSession.close();
        return list;
    }
}
