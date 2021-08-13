package com.lin.aliyuntool.api;

import java.util.HashMap;
import java.util.Map;

import com.aliyun.asapi.ASClient;

import com.lin.aliyuntool.entity.requestParams;

public class Ascm_Api {
	public static String GetOrganizationTree(requestParams rp) {
    	try {
    		Map<String, Object> requestParams = new HashMap<String, Object>();
     		requestParams.put("action", "GetOrganizationTree");
     		requestParams.put("product", "ascm");
		    requestParams.put("Version", "2019-05-10");
		    requestParams.put("RegionId", rp.getRegionId());
     	    requestParams.put("AccessKeyId", rp.getAccessKeyId());
     	    requestParams.put("AccessKeySecret", rp.getAccessKeySecret());
     	    requestParams.put("Id", "1");


     		ASClient client = new ASClient();
     		client.addHeader("User-Agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1)");
     		String result = client.doRequest(rp.getApiGateWay(), requestParams);

     		System.out.println("GetOrganizationTree API Success!");
     		return result;
     	} catch (Exception e) {
     		System.out.println("GetOrganizationTree API Error!");
     		e.printStackTrace();
     		return null;
     	}
    }


	public static String GetUserInfo(requestParams rp) {
    	try {
    		Map<String, Object> requestParams = new HashMap<String, Object>();
     		requestParams.put("action", "GetUserInfo");
     		requestParams.put("product", "ascm");
		    requestParams.put("Version", "2019-05-10");
		    requestParams.put("RegionId", rp.getRegionId());
     	    requestParams.put("AccessKeyId", rp.getAccessKeyId());
     	    requestParams.put("AccessKeySecret", rp.getAccessKeySecret());


     		ASClient client = new ASClient();
     		client.addHeader("User-Agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1)");
     		String result = client.doRequest(rp.getApiGateWay(), requestParams);

     		System.out.println("GetUserInfo API Success!");
     		return result;
     	} catch (Exception e) {
     		System.out.println("GetUserInfo API Error!");
     		e.printStackTrace();
     		return null;
     	}
    }

}
