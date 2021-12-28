package com.louis.info.service;

import com.louis.info.pojo.User;

import java.util.List;

/**
 * 赖小燚
 * www.louis.com
 */
public interface UserService {

    User getUserByPhonenumber(String phonenumber);

    User getUserById(Integer id);

    User getUserByEmail(String email);

    int updateUserInfo(User user);

    List<User> getAllUser();

    int deleteUserById(Integer id);

    int getUserCount();

    int addUser(User user);

    Integer generateId();

    int addUser4Param(Integer id,String username,String password,String phonenumber);
}
