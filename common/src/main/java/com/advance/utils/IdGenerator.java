package com.advance.utils;

import xyz.downgoon.snowflake.Snowflake;

/**
 * @program: dubboDemo
 * @description: 雪花算法生成类
 * @author: zhouh
 * @create: 2020-08-04 15:14
 **/
public class IdGenerator {

    public static long generatorCode(){
        Snowflake snowflake = new Snowflake(2, 0);
        return snowflake.nextId();
    }

}
