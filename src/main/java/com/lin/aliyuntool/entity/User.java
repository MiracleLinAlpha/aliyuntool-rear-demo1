package com.lin.aliyuntool.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    String accessKeyId;
    String accessKeySecret;
    String displayName;
    String regionId;
    String apiGateWay;
}
