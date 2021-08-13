package com.lin.aliyuntool.mapper;


import com.lin.aliyuntool.entity.ApiUserRequest;

public interface UserMapper {
    ApiUserRequest findByUser(ApiUserRequest user);
    ApiUserRequest findByAccessKeyId(String AccessKeyId);
}
