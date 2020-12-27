package com.dolphin.service.impl;

import com.dolphin.pojo.Users;
import com.dolphin.service.UserService;
import org.junit.Test;

import static org.junit.Assert.*;

public class UpdateUsersTest {

    @Test
    public void preUpdateUsers() {
        UserService userService = new UserServiceImpl();
        Users users = userService.preUpdateUsers(2);
        //System.out.println(users.getUserid());
        users.setUsername("OLDLU");
        users.setUsersex("MALE");
        userService.modifyUsers(users);
    }
}