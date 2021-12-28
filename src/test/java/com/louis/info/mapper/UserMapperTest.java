package com.louis.info.mapper;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.louis.info.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

@ContextConfiguration(locations = "classpath:spring/spring.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class UserMapperTest {

    @Autowired
    UserMapper userMapper;

    @Test
    public void getUserByPhonenumber() {
        User user = userMapper.getUserByPhonenumber("17730229300");
        System.out.println(user);
    }

    @Test
    public void getUserById() {
        User user = userMapper.getUserById(20277307);
        System.out.println(user);
    }

    @Test
    public void getUserByEmail() {
        User user = userMapper.getUserByEmail("17730229300@qq.com");
        System.out.println(user);
    }

    @Test
    public void updateUserInfo() {
        User user = new User();
        user.setId(10000003);
        user.setUsername("测试1");
        user.setPassword("123456");
        user.setGender("男");
        user.setEducation("小学");
        user.setPhonenumber("13905698865");
        user.setAddress("海南省海口市");
        user.setEmail("13905698865@qq.com");
        user.setHeight(185);
        user.setWeight(109);
        user.setImageUrl("default.jpg");
        user.setRoleName("普通用户");
        userMapper.updateUserInfo(user);
    }

    @Test
    public void getAllUser() {
        Page<User> page = PageHelper.startPage(2,10);
        List<User> userList = userMapper.getAllUser();
        for(User user : userList){
            System.out.println(user);
        }
        System.out.println(userList.size());
        System.out.println("页面大小："+page.getPageSize());
        System.out.println("当前页："+page.getPageNum());
        System.out.println("总页数"+page.getPages());
        System.out.println("总记录数"+page.getTotal());
    }

    @Test
    public void deleteUserById() {
        userMapper.deleteUserById(10000003);
    }

    @Test
    public void getUserCount() {
        System.out.println(userMapper.getUserCount()/15+1);
    }

    @Test
    public void addUser() {
        User user = new User();
        user.setId(10000013);
        user.setUsername("测试10");
        user.setPassword("123456");
        user.setGender("男");
        user.setEducation("小学");
        user.setPhonenumber("13905698865");
        user.setAddress("海南省海口市");
        user.setEmail("13905698865@qq.com");
        user.setHeight(185);
        user.setWeight(109);
        user.setImageUrl("default.jpg");
        user.setRoleName("普通用户");
        userMapper.addUser(user);
    }

    @Test
    public void generateId() {
        System.out.println(userMapper.generateId());
    }

    @Test
    public void addUser4Param() {
        userMapper.addUser4Param(20411222,"孙中山","123456","11111111111");
    }
}