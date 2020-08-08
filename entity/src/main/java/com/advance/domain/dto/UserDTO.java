package com.advance.domain.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @program: dubboDemo
 * @description: 用户查询实体类
 * @author: zhouh
 * @create: 2020-07-08 17:34
 **/
@Data
@NoArgsConstructor
public class UserDTO implements Serializable {

    private int id;

    private String account;

    private String password;

    private String name;

    private String phone;

    private String status;

}
