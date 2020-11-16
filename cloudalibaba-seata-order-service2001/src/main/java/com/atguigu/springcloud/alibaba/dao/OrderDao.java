package com.atguigu.springcloud.alibaba.dao;

import com.atguigu.springcloud.alibaba.domain.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * [用一句话描述此类]
 *
 * @author: liuzx
 * @create: 2020-10-28 17:01
 **/
@Mapper
public interface OrderDao {
    //1 新建订单
    void create(Order order);

    //2修改订单状态，从0改成1
    void update(@Param("userId") Long userId,@Param("status") Integer status);


}
