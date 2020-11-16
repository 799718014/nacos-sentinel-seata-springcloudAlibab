package com.atguigu.springcloud.alibaba.service;

/**
 * [用一句话描述此类]
 *
 * @author: liuzx
 * @create: 2020-11-09 10:35
 **/
public interface StorageService {

    /**
     * [扣减库存]
     * @author: liuzx
     * @date: 2020/11/9
     **/
    void decrease(Long productId,Integer count);
}
