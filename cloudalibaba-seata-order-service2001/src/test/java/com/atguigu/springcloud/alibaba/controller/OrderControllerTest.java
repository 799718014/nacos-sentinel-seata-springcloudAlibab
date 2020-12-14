package com.atguigu.springcloud.alibaba.controller;

import com.atguigu.springcloud.alibaba.SeataOrderMainApp2001;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;

/**
 * [用一句话描述此类]
 *
 * @author: liuzx
 * @create: 2020-11-16 16:21
 **/

/*@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes={SeataOrderMainApp2001.class,OrderControllerTest.class})*/
public class OrderControllerTest extends BaseTest{
    private static String baseUrl = "http://127.0.0.1:2001";

    @Test
    public void getOrder() throws IOException {
        String url = baseUrl + "/order";
        String paramStr = "";
        //String paramStr = "K2=V2&userCode=111111&K1=V1";
        //进行签名
        this.httpGet(url);
    }

    @Test
    public void createOrder() throws IOException {
        String url = baseUrl + "/order/create?";
        String paramStr = "userId=1&productId=1&count=10&money=70";
        //进行签名
        this.httpGet(url+paramStr);
    }
}