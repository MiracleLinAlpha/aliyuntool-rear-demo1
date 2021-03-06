package com.lin.aliyuntool.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.lin.aliyuntool.entity.ApiUserRequest;
import org.springframework.stereotype.Service;


@Service("TokenService")
public class TokenService {
    public String getToken(ApiUserRequest user) {
        String token="";
        token= JWT.create().withAudience(user.getAccessKeyId())// 将 user id 保存到 token 里面
                .sign(Algorithm.HMAC256(user.getAccessKeySecret()));// 以 password 作为 token 的密钥
        return token;
    }
}
