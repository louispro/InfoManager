package com.louis.info.service.impl;

import com.louis.info.mapper.UserMapper;
import com.louis.info.pojo.User;
import com.louis.info.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 赖小燚
 * www.louis.com
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUserByPhonenumber(String phonenumber) {
        return userMapper.getUserByPhonenumber(phonenumber);
    }

    @Override
    public User getUserById(Integer id) {
        return userMapper.getUserById(id);
    }

    @Override
    public User getUserByEmail(String email) {
        return userMapper.getUserByEmail(email);
    }

    @Override
    public int updateUserInfo(User user) {
        return userMapper.updateUserInfo(user);
    }

    @Override
    public List<User> getAllUser() {
        return userMapper.getAllUser();
    }

    @Override
    public int deleteUserById(Integer id) {
        return userMapper.deleteUserById(id);
    }

    @Override
    public int getUserCount() {
        return userMapper.getUserCount();
    }

    @Override
    public int addUser(User user) {
        return userMapper.addUser(user);
    }

    @Override
    public Integer generateId() {
        return userMapper.generateId();
    }

    @Override
    public int addUser4Param(Integer id, String username, String password, String phonenumber) {
        return userMapper.addUser4Param(id,username,password,phonenumber);
    }


}
