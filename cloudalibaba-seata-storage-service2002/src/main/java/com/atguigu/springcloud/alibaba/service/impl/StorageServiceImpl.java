package com.atguigu.springcloud.alibaba.service.impl;

import com.atguigu.springcloud.alibaba.dao.StorageDao;
import com.atguigu.springcloud.alibaba.service.StorageService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


/**
 * [用一句话描述此类]
 *
 * @author: liuzx
 * @create: 2020-11-09 10:37
 **/
@Service
@Slf4j
public class StorageServiceImpl implements StorageService {
    private static  final Logger LOGGER = LoggerFactory.getLogger(StorageServiceImpl.class);

    @Resource
    private StorageDao storageDao;


    /**
     * [扣减库存]
     * @author: liuzx
     * @date: 2020/11/9
     **/
    @Override
    public void decrease(Long productId,Integer count){
        LOGGER.info("------->storage-service中扣减库存开始");
        storageDao.decrease(productId,count);
        LOGGER.info("------->storage-service中扣减库存结束");
    }


}
