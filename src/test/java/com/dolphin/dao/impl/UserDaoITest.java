package com.dolphin.dao.impl;

import com.dolphin.dao.UserDao;
import com.dolphin.pojo.Users;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.*;

public class UserDaoITest {

    @Test
    public void selectUsersAll() throws IOException {
        UserDao userDao = new UserDaoImpl();
        List<Users> users = userDao.selectUsersAll();
        for (Users u:users) {
            System.out.println(u.getUserid()+"\t"+u.getUsername());
        }
    }

    @Test
    public void selectUserById() throws IOException {
        UserDao userDao = new UserDaoImpl();
        Users u = userDao.selectUserById(1);
        System.out.println(u.getUserid()+"\t"+u.getUsername());
    }
}