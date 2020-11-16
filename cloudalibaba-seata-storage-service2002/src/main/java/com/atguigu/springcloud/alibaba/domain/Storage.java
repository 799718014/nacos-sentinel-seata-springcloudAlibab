package com.atguigu.springcloud.alibaba.domain;

import lombok.Data;

/**
 * [用一句话描述此类]
 *
 * @author: liuzx
 * @create: 2020-11-09 10:25
 **/

@Data
public class Storage {

    private Long id;

    /**
     * 产品id
     */
    private Long productId;

    /**
     * 总库存
     */
    private Integer total;

    /**
     * 已用库存
     */
    private Integer used;

    /**
     * 剩余库存
     */
    private Integer residue;

}
