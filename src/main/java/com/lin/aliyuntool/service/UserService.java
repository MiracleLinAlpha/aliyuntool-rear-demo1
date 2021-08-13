package com.lin.aliyuntool.service;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lin.aliyuntool.api.Ascm_Api;
import com.lin.aliyuntool.entity.ApiUserRequest;
import com.lin.aliyuntool.entity.requestParams;
import org.springframework.stereotype.Service;

@Service("UserService")
public class UserService {
    requestParams rp = new requestParams();
    String resultJson;
    ApiUserRequest temp = new ApiUserRequest();
    String displayName;

    public ApiUserRequest findByUser(ApiUserRequest user) {

        temp = user;

        rp.setApiGateWay(temp.getApiGateWay());
        rp.setRegionId(temp.getRegionId());
        rp.setAccessKeyId(temp.getAccessKeyId());
        rp.setAccessKeySecret(temp.getAccessKeySecret());

        resultJson = new Ascm_Api().GetUserInfo(rp);

        if (resultJson.contains("displayName")) {

            try {
                ObjectMapper mapper = new ObjectMapper();
                mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);
                mapper.setDefaultPropertyInclusion(JsonInclude.Include.NON_DEFAULT);
                mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);

                JsonNode userinfojn = mapper.readTree(resultJson);
                userinfojn = userinfojn.get("data").get("displayName");
                displayName = userinfojn.toString();

                temp.setDisplayName(displayName);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }

            return temp;
        } else {
            return null;
        }
    }
    public ApiUserRequest findUserByAccessKeyId(String AccessKeyId) {

        ApiUserRequest temp = new ApiUserRequest();
        temp.setAccessKeyId("admin");
        temp.setAccessKeySecret("111111");
        temp.setDisplayName("高运成");

        if (AccessKeyId.equals("admin")){
            return temp;
        }
        return null;
    }


}
