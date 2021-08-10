package com.lin.aliyuntool.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JacksonUtil {
    private static ObjectMapper objectMapper;
    static {
        objectMapper = new ObjectMapper();
    }

    public static <T> String beanToJson(T bean) {
        try {
            return objectMapper.writeValueAsString(bean);
        } catch (JsonProcessingException e) {
            return null;
        }
    }
}
