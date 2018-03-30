package com.chunmi.vote.test;

import java.io.IOException;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONObject;

@Slf4j
public class PracticeClass {


	/**
	 * 获取网络响应结果
	 * @param url
	 * @param params
	 * @return
	 */
	public String getResponse(String url,Map<String,Object> params) {
		CloseableHttpClient httpClient = null;
		CloseableHttpResponse response = null;
		try {
			JSONObject jsonObj = JSONObject.fromObject(params);
			httpClient = HttpClients.createDefault();
			HttpPost httpPost= new HttpPost(url);
			httpPost.setEntity(new StringEntity(jsonObj.toString(), "UTF-8"));
			response = httpClient.execute(httpPost);
			HttpEntity entity = response.getEntity();
			return EntityUtils.toString(entity);
		} catch (Exception e) {
			log.error(e.getMessage());
			return null;
		}
		finally {
				try {
					if(response!=null) {
						response.close();
					}
					if(httpClient !=null) {
						httpClient.close();
					}
				} catch (IOException e) {
					log.error(e.getMessage());
				}
		}
	}
	
	
	public static void main(String[] args) {
		String[] strArray = new String[] {"我","是","王","晴","天","很","爱","黄","映","然"};
		//正常循环打印全部
		for(int i =0;i<strArray.length;i++) {
			System.out.print(strArray[i]+"\t");
		}
		
		System.out.println("=========以下是非正常打印==========");
		//出现非正常打印，当循环读到"天"的时候，则return
		for(int i =0;i<strArray.length;i++) {
			System.out.print(strArray[i]+"\t");
			if(strArray[i].equals("天")) {
				return;
			}
		}
	}
}
