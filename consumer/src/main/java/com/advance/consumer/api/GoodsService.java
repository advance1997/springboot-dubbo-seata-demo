package com.advance.consumer.api;

import com.advance.domain.entity.Goods;
import com.advance.goods.api.IGoodsService;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: dubboDemo
 * @description: 商品服务消费者
 * @author: zhouh
 * @create: 2020-08-04 13:09
 **/
@Service
public class GoodsService {

    @Reference(cluster = "failfast", retries = 3, interfaceClass = IGoodsService.class, lazy = true, check = false, timeout = 5000)
    IGoodsService goodsService;

    public void addGoods(Goods goods){
        goodsService.insertGoods(goods);
    }

    public List<Goods> listGoods(){
        return goodsService.getGoodsList();
    }

    public void reduceGoodsNum(Integer goodsId) {
        goodsService.reduceNum(goodsId);
    }

    public void deleteGoods(Integer goodsId){
        goodsService.deleteGoods(goodsId);
    }

    public Goods getGoodsById(Integer goodsId){
        return goodsService.getGoodsById(goodsId);
    }

}
