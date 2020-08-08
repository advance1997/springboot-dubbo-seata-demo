package com.advance.generator;

import xyz.downgoon.snowflake.Snowflake;

/**
 * @program: dubboDemo
 * @description: 使用雪花算法生成id
 * @author: zhouh
 * @create: 2020-07-15 14:28
 **/
public class IdGenerator {

    public static void main(String[] args) {
        Snowflake snowflake = new Snowflake(2, 0);
        long startTime = System.currentTimeMillis();
        for(int i = 0; i < 100000; i++){
            System.out.println(snowflake.nextId());
        }
        long endTime = System.currentTimeMillis();
        System.out.println((endTime - startTime) + "毫秒");
    }

}
