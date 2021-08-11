package com.lin.aliyuntool.service;

import com.lin.aliyuntool.entity.User;
import com.lin.aliyuntool.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("UserService")
public class UserService {
    UserMapper userMapper;
    String resultJson;

    public User findByUser(User user){
//        return userMapper.findByUser(user);
        User temp = new User();

        resultJson = "aaaaadisplayNameaaaaa";

        if (resultJson.contains("displayName")) {

            temp.setAccessKeyId("admin");
            temp.setAccessKeySecret("111111");
            temp.setDisplayName("高运成");

            return temp;
        } else {
            return null;
        }
    }
    public User findUserByAccessKeyId(String AccessKeyId) {
//        return userMapper.findByAccessKeyId(AccessKeyId);

        User temp = new User();
        temp.setAccessKeyId("admin");
        temp.setAccessKeySecret("111111");
        temp.setDisplayName("高运成");

        if (AccessKeyId.equals("admin")){
            return temp;
        }
        return null;
    }


}
