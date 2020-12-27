package com.dolphin.service;

import com.dolphin.pojo.Users;

public interface UserService {
    void addUsers(Users users);
    Users preUpdateUsers(int userid);
    void modifyUsers(Users users);
    void deleteUsersById(int userid);
}
