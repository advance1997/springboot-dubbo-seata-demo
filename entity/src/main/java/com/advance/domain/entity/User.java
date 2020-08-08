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
*   用户表
* </p>
*
* @author advance - 周舟
* @since 2020-07-21
*/
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.AUTO)
    private Integer id;

//    @No
    private String account;

    private String password;

    private String name;

    private String email;

    private String phone;

    private Integer age;

    private String address;

    private String sex;

    private String status;

    private LocalDateTime createTime;

}
