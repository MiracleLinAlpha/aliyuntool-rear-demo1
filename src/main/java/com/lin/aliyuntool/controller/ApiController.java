package com.lin.aliyuntool.controller;

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

        User userForBase=userService.findByUser(user);
        if(userForBase==null){
            Map m = new HashMap();
            m.put("message","登录失败,用户名或密码错误");
            return JacksonUtil.beanToJson(m);
        }else {
            String token = tokenService.getToken(userForBase);
            Map m = new HashMap();
            m.put("token", token);
            m.put("AccessKeyId", userForBase.getDisplayName());
            return JacksonUtil.beanToJson(m);
        }
    }

    @UserLoginToken
    @GetMapping("/getMessage")
    public String getMessage(){
        return "你已通过验证";
    }


    @GetMapping("/logout")
    public String logout(){
        return "退出";
    }

}
