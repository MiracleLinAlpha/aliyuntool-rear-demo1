package com.lin.aliyuntool.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.lin.aliyuntool.annotation.UserLoginToken;
import com.lin.aliyuntool.entity.ApiSecurityGroupRequest;
import com.lin.aliyuntool.entity.ApiUserRequest;
import com.lin.aliyuntool.service.SecurityGruoupService;
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

    @Autowired
    SecurityGruoupService securitygroupservice;



    //登录
    @PostMapping("/login")
    public Object login(@RequestBody ApiUserRequest user) throws JsonProcessingException {

        ApiUserRequest userForBase=userService.findByUser(user);
        if(userForBase==null){
            Map m = new HashMap();
            m.put("message","登录失败,用户名或密码错误");
            return JacksonUtil.beanToJson(m);
        }else {
            String token = tokenService.getToken(userForBase);
            Map m = new HashMap();
            m.put("token", token);
            m.put("DisplayName", userForBase.getDisplayName());
            return JacksonUtil.beanToJson(m);
        }
    }

    //查询token是否存在
    @UserLoginToken
    @GetMapping("/getMessage")
    public String getMessage(){
        return "你已通过验证";
    }




    //退出
    @GetMapping("/logout")
    public String logout(){
        return "退出";
    }






    @UserLoginToken
    @PostMapping("/doSecurityGroupRule")
    public String doSecurityGroupRule(ApiSecurityGroupRequest asgr, String action) {

        if (action.equals("AddToAll")) {

            securitygroupservice.AddToAll();

        } else if (action.equals("AddByIP")) {

            securitygroupservice.AddByIP();

        } else if (action.equals("AddByGroupId")) {

            securitygroupservice.AddByGroupId();

        } else if (action.equals("DeleteToAll")) {

            securitygroupservice.DeleteToAll();

        } else if (action.equals("DeleteByIP")) {

            securitygroupservice.DeleteByIP();

        } else if (action.equals("DeleteByGroupId")) {

            securitygroupservice.DeleteByGroupId();

        } else if (action.equals("Migration")) {

            securitygroupservice.Migration();

        }

        return "params error";
    }



}
