package com.louis.info.mapper;

import com.louis.info.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 赖小燚
 * www.louis.com
 */
@Repository
public interface UserMapper {

    User getUserByPhonenumber(String phonenumber);

    User getUserById(Integer id);

    User getUserByEmail(String email);

    int updateUserInfo(User user);

    List<User> getAllUser();

    int deleteUserById(Integer id);

    int getUserCount();

    int addUser(User user);

    int addUser4Param(@Param("id")Integer id,@Param("username")String username,@Param("password")String password,@Param("phonenumber")String phonenumber);

    Integer generateId();

}
