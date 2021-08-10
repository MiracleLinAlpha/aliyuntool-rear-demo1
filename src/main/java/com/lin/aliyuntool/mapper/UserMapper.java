package com.lin.aliyuntool.mapper;


import com.lin.aliyuntool.entity.User;

/**
 * @author jinbin
 * @date 2018-07-08 20:44
 */
public interface UserMapper {
    User findByUsername(@Param("username") String username);
    User findUserById(@Param("Id") String Id);
}
