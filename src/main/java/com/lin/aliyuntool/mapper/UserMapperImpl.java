package com.lin.aliyuntool.mapper;

import com.lin.aliyuntool.entity.ApiUserRequest;

public class UserMapperImpl implements UserMapper {

    @Override
    public ApiUserRequest findByUser(ApiUserRequest user) {
        System.out.println("bbbbbb");
        ApiUserRequest temp = new ApiUserRequest();
        temp.setAccessKeyId("admin");
        temp.setAccessKeySecret("111111");
        temp.setDisplayName("高运成");

        return temp;
    }

    @Override
    public ApiUserRequest findByAccessKeyId(String AccessKeyId) {
        ApiUserRequest temp = new ApiUserRequest();
        temp.setAccessKeyId("admin");
        temp.setAccessKeySecret("111111");
        temp.setDisplayName("高运成");

        return temp;
    }
}
