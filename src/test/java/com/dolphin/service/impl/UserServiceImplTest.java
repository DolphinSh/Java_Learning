package com.dolphin.service.impl;

import com.dolphin.service.UserService;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserServiceImplTest {

    @Test
    public void deleteUsersById() {
        UserService userService =  new UserServiceImpl();
        userService.deleteUsersById(4);
    }
}