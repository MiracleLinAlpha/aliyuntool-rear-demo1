package com.lin.aliyuntool.mapper;

import com.lin.aliyuntool.entity.User;

public class UserMapperImpl implements UserMapper {

    @Override
    public User findByUser(User user) {
        System.out.println("bbbbbb");
        User temp = new User();
        temp.setAccessKeyId("admin");
        temp.setAccessKeySecret("111111");
        temp.setDisplayName("高运成");

        return temp;
    }

    @Override
    public User findByAccessKeyId(String AccessKeyId) {
        User temp = new User();
        temp.setAccessKeyId("admin");
        temp.setAccessKeySecret("111111");
        temp.setDisplayName("高运成");

        return temp;
    }
}
