package com.lin.aliyuntool.mapper;


import com.lin.aliyuntool.entity.User;

public interface UserMapper {
    User findByUser(User user);
    User findByAccessKeyId(String AccessKeyId);
}
