package com.advance.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
* <p>
*   订单表
* </p>
*
* @author advance - 周舟
* @since 2020-07-21
*/
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Deposit implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId
    private long itemOrder;

    private Integer userId;

    private Integer goodsId;

    private double price;

    private String nickName;

    private String address;

    private String status;

    private LocalDateTime createTime;

}
