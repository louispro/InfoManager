package com.louis.info.service.impl;

import com.louis.info.mapper.UserMapper;
import com.louis.info.pojo.User;
import com.louis.info.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@ContextConfiguration(locations = "classpath:spring/spring.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class UserServiceImplTest {

    @Autowired
    private UserService userService;

    @Test
    public void updateUserInfo() {
        User user = new User();
        user.setId(20211222);
        user.setUsername("辛谷日");
        user.setEducation("小学");
        user.setPhonenumber("13905698865");
        user.setAddress("海南省海口市");
        user.setEmail("13905698865@qq.com");
        user.setHeight(185);
        user.setWeight(111);
        userService.updateUserInfo(user);
    }

    @Test
    public void addUser() {
        User user = new User();
        user.setId(20411221);
        user.setUsername("1");
        user.setPassword("1");
        user.setPassword("1");
        user.setGender("1");
        user.setEducation("1");
        user.setPhonenumber("1");
        user.setAddress("1");
        user.setEmail("1");
        user.setHeight(1);
        user.setWeight(1);
        user.setImageUrl("1");
        user.setRoleName("普通用户");
        userService.addUser(user);
    }
}