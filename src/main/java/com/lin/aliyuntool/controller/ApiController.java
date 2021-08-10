package com.lin.aliyuntool.controller;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lin.aliyuntool.annotation.UserLoginToken;
import com.lin.aliyuntool.entity.User;
import com.lin.aliyuntool.service.TokenService;
import com.lin.aliyuntool.service.UserService;
import com.lin.aliyuntool.util.JacksonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("api")
public class ApiController {
    @Autowired
    UserService userService;
    @Autowired
    TokenService tokenService;
    //登录
    @PostMapping("/login")
    public Object login(@RequestBody User user){
//        JSONObject jsonObject=new JSONObject();

        System.out.println(user.getUsername());
        System.out.println(user.getPassword());
        User userForBase = new User();
        if (user.getUsername().equals("admin") && user.getPassword().equals("111111")){
            userForBase.setId("1");
            userForBase.setUsername("admin");
            userForBase.setPassword("111111");

            String token = tokenService.getToken(userForBase);
//            jsonObject.put("token", token);
//            jsonObject.put("user", userForBase);

            Map m = new HashMap();
            m.put("token", token);
            m.put("user", userForBase);


            return JacksonUtil.beanToJson(m);
        } else if (user.getUsername().equals("admin") && user.getPassword().equals("111111") == false){
//            jsonObject.put("message","登录失败,密码错误");

            Map m = new HashMap();
            m.put("message","登录失败,密码错误");
            return JacksonUtil.beanToJson(m);
        } else {
//            jsonObject.put("message","登录失败,用户不存在");

            Map m = new HashMap();
            m.put("message","登录失败,用户不存在");
            return JacksonUtil.beanToJson(m);
        }

    }

    @UserLoginToken
    @GetMapping("/getMessage")
    public String getMessage(){
        return "你已通过验证";
    }


}
