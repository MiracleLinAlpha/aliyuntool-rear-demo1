package com.lin.aliyuntool.interceptor;

import com.lin.aliyuntool.util.JacksonUtil;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GloablExceptionHandler {
    @ResponseBody
    @ExceptionHandler(Exception.class)
    public Object handleException(Exception e) {
        String msg = e.getMessage();
        if (msg == null || msg.equals("")) {
            msg = "服务器出错";
        }
//        JSONObject jsonObject = new JSONObject();
//        jsonObject.put("message", msg);

        Map m = new HashMap();
        m.put("message", msg);

        return JacksonUtil.beanToJson(m);
    }
}
