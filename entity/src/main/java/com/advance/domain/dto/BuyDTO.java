package com.advance.domain.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @program: dubboDemo
 * @description: 下单传参实体
 * @author: zhouh
 * @create: 2020-08-04 18:25
 **/
@Data
@NoArgsConstructor
public class BuyDTO implements Serializable {

    private Integer userId;

    private Integer goodsId;

}
