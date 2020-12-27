package com.dolphin.dao.impl;

import com.dolphin.dao.UserDao;
import com.dolphin.pojo.Users;
import com.dolphin.utils.MybatisUtils;
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

    @Override
    public Users selectUserById(int userId) throws IOException {
        //创建SqlSessionFactory对象
        InputStream inputStream = Resources.getResourceAsStream("mybatis-cfg.xml");
        SqlSessionFactory sqlSessionFacotry = new SqlSessionFactoryBuilder().build(inputStream);
        //获取SqlSession对象
        SqlSession sqlSession = sqlSessionFacotry.openSession();
        //通过SqlSession对象下的API完成对数据库的操作
        Users u = sqlSession.selectOne("com.dolphin.mapper.UsersMapper.selectUserById",userId);
        //关闭SqlSession对象
        sqlSession.close();
        return u;

    }

    /**
     * 添加用户
     * 对于事物的控制，需要在业务层中完成
     */
    @Override
    public void insertUser(Users users) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        //insert 有返回值，返回 影响的行数
        int insert =  sqlSession.insert("com.dolphin.mapper.UsersMapper.insertUser",users);

    }

    /**
     *
     * 预更新用户的查询
     * @param userid
     * @return
     */
    @Override
    public Users selectUsersById2(int userid) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        Users u = sqlSession.selectOne("com.dolphin.mapper.UsersMapper.selectUserById2",userid);
        return u;
    }

    /**
     * 更新用户
     *
     * @param users
     */
    @Override
    public void updateUsersById(Users users) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        int update = sqlSession.update("com.dolphin.mapper.UsersMapper.updateUsersById",users);
    }

    /**
     * 删除用户
     * @param userid
     */
    @Override
    public void deleteUsersById(int userid) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        int delete = sqlSession.delete("com.dolphin.mapper.UsersMapper.deleteUsersById",userid);
    }
}
