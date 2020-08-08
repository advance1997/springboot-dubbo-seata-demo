package com.advance.goods.api;

import com.advance.domain.entity.Goods;

import java.util.List;

/**
 * @ClassName IGoodsService
 * @Description TODO
 * @Author advance - 周舟
 * @Date 2020/8/4 10:16
 * @Version V1.0
 **/
public interface IGoodsService {

    void insertGoods(Goods goods);

    List<Goods> getGoodsList();

    void reduceNum(Integer goodsId);

    void deleteGoods(Integer goodsId);

    Goods getGoodsById(Integer goodsId);

}
