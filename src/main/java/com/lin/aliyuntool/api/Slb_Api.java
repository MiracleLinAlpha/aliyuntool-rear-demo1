package com.lin.aliyuntool.api;

import java.util.HashMap;
import java.util.Map;

import com.aliyun.asapi.ASClient;

import com.lin.aliyuntool.entity.requestParams;

public class Slb_Api {
	public static String DescribeLoadBalancers(requestParams rp) {
    	try {
    		Map<String, Object> requestParams = new HashMap<String, Object>();
     		requestParams.put("action", "DescribeLoadBalancers");
     		requestParams.put("product", "Slb");
		    requestParams.put("Version", "2014-05-15");
		    requestParams.put("RegionId", rp.getRegionId());
     	    requestParams.put("AccessKeyId", rp.getAccessKeyId());
     	    requestParams.put("AccessKeySecret", rp.getAccessKeySecret());


     		ASClient client = new ASClient();
     		client.addHeader("User-Agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1)");
     		String result = client.doRequest(rp.getApiGateWay(), requestParams);

     		System.out.println("DescribeLoadBalancers API Success!");
     		return result;
     	} catch (Exception e) {
     		System.out.println("DescribeLoadBalancers API Error!");
     		e.printStackTrace();
     		return null;
     	}
    }
}
