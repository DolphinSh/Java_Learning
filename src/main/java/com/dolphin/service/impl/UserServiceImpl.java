package com.dolphin.service.impl;

import com.dolphin.dao.UserDao;
import com.dolphin.dao.impl.UserDaoImpl;
import com.dolphin.pojo.Users;
import com.dolphin.service.UserService;
import com.dolphin.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

public class UserServiceImpl implements UserService {
    /**
     *
     * 添加用户
     * @param users 添加用户
     */
    @Override
    public void addUsers(Users users) {
        SqlSession sqlSession =  MybatisUtils.getSqlSession();
        try{
            UserDao userDao = new UserDaoImpl();
            userDao.insertUser(users);
            sqlSession.commit();
        }catch (Exception e){
            //实现统一的事物处理，遇到错误，进行回滚
            e.printStackTrace();
            sqlSession.rollback();
        }finally {
            MybatisUtils.closeSqlSession();
        }
    }

    @Override
    public Users preUpdateUsers(int userid) {
        Users users= null;
        try{
            SqlSession sqlSession = MybatisUtils.getSqlSession();
            UserDao userDao = new UserDaoImpl();
            users =  userDao.selectUsersById2(userid);
            System.out.println("第一次"+ sqlSession);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            MybatisUtils.closeSqlSession();
        }
        return users;
    }

    /**
     * 修改用户信息
     * @param users
     */
    @Override
    public void modifyUsers(Users users) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        try{
            UserDao userDao = new UserDaoImpl();
            userDao.updateUsersById(users);
            sqlSession.commit();
            System.out.println("第二次"+ sqlSession);
        }catch (Exception e){
            e.printStackTrace();
            sqlSession.rollback();
        }finally {
            MybatisUtils.closeSqlSession();
        }
    }

    /**
     * 根据用户id 删除用户
     * @param userid
     */
    @Override
    public void deleteUsersById(int userid) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        try{
            UserDao userDao = new UserDaoImpl();
            userDao.deleteUsersById(userid);
            sqlSession.commit();
        }catch (Exception e){
            e.printStackTrace();
            sqlSession.rollback();
        }finally {
            MybatisUtils.closeSqlSession();
        }
    }
}
