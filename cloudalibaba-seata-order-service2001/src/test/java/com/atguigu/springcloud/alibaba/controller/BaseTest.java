package com.atguigu.springcloud.alibaba.controller;

import com.alibaba.fastjson.JSON;
import com.google.protobuf.MessageOrBuilder;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.util.Assert;

import java.io.IOException;

/**
 *
 */
public class BaseTest {
	protected CloseableHttpClient httpClient;
	protected String baseUrl = "";
	protected String cookies = "token=dc362729-2c49-4e9c-8a0d-0d4df3952251";

	public BaseTest() {
		httpClient = HttpClients.createDefault();
	}


	/**
	 * 发起Post请求
	 *
	 * @param url
	 * @param message
	 * @throws IOException
	 */
	protected void httpPost(String url, MessageOrBuilder message) throws IOException {
		//发起HTTP请求
		HttpPost httpPost = new HttpPost(url);
		StringEntity stringEntity = new StringEntity(JSON.toJSON(message).toString(), ContentType.APPLICATION_JSON);
		stringEntity.setContentEncoding("UTF-8");
		httpPost.setEntity(stringEntity);// 通过请求对象获取响应对象
		httpPost.setHeader("cookie", cookies);
		CloseableHttpResponse response = httpClient.execute(httpPost);
		// 判断网络连接状态码是否正常
		Assert.isTrue(response.getStatusLine().getStatusCode() == HttpStatus.SC_OK, "HTTP 返回码不为 200");
		// 获取结果实体
		String result = EntityUtils.toString(response.getEntity());
		// 释放链接
		response.close();
		System.out.println("------返回结果--------");
		System.out.println(result);
	}

	/**
	 * 发起Http Get 请求
	 *
	 * @param url
	 * @throws IOException
	 */
	protected void httpGet(String url) throws IOException {
		// 创建get方式请求对象
		HttpGet httpGet = new HttpGet(url);
		httpGet.setHeader("Cookie", cookies);
		// 通过请求对象获取响应对象
		CloseableHttpResponse response = httpClient.execute(httpGet);
		// 判断网络连接状态码是否正常
		Assert.isTrue(response.getStatusLine().getStatusCode() == HttpStatus.SC_OK, "HTTP 返回码不为 200");
		// 获取结果实体
		String result = EntityUtils.toString(response.getEntity(), "UTF-8");
		// 释放链接
		response.close();
		System.out.println("------返回结果--------");
		System.out.println(result);
	}
}
