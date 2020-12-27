package com.dolphin.dao;

import com.dolphin.pojo.Users;

import java.io.IOException;
import java.util.List;

public interface UserDao {
    List<Users> selectUsersAll() throws IOException;
    Users selectUserById(int userId) throws IOException;
}
