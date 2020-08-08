package com.advance.bussiness.api;

import com.advance.domain.dto.BuyDTO;

/**
 * @program: dubboDemo
 * @description:
 * @author: zhouh
 * @create: 2020-08-05 22:03
 **/
public interface IBussinessService {

    void purchases(BuyDTO buyDTO);

}
