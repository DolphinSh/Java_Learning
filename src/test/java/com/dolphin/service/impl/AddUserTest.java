package com.dolphin.service.impl;

import com.dolphin.pojo.Users;
import com.dolphin.service.UserService;
import org.junit.Test;

import static org.junit.Assert.*;

public class AddUserTest {
    @Test
    public void addUserTest(){
        UserService userService = new UserServiceImpl();
        Users users = new Users();
        //存在bug 中文乱码
        users.setUsername("zhangsan");
        users.setUsersex("male");
        userService.addUsers(users);
    }

}