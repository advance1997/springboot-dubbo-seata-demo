package com.advance.goods.provider.service;

import com.advance.consts.SysConsts;
import com.advance.domain.entity.Goods;
import com.advance.goods.api.IGoodsService;
import com.advance.goods.provider.mapper.GoodsMapper;
import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.seata.core.context.RootContext;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @program: dubboDemo
 * @description: 商品服务提供类
 * @author: zhouh
 * @create: 2020-08-04 12:50
 **/
@Service
public class GoodsServiceImpl extends ServiceImpl<GoodsMapper, Goods> implements IGoodsService {
    @Override
    public void insertGoods(Goods goods) {
        goods.setStatus(SysConsts.DATA_VAILD);
        goods.setCreateTime(LocalDateTime.now());
        save(goods);
    }

    @Override
    public List<Goods> getGoodsList() {
        return list();
    }

    @Override
    public void reduceNum(Integer goodsId) {
        System.out.println("Goods-全局事务id"+ RootContext.getXID());
        Goods goods = getById(goodsId);
        int lastNum = goods.getNum() - 1;
        UpdateWrapper<Goods> updateWrapper = new UpdateWrapper<>();
        updateWrapper.lambda().set(Goods::getNum, lastNum).eq(Goods::getId, goodsId);
        update(updateWrapper);
    }

    @Override
    public void deleteGoods(Integer goodsId) {
        removeById(goodsId);
    }

    @Override
    public Goods getGoodsById(Integer goodsId) {
        return getById(goodsId);
    }
}
