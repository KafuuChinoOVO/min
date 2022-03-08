package com.scxh.ssm.service;

import com.scxh.ssm.domain.OrdersDetailsVo;
import com.scxh.ssm.domain.OrdersVo;

import java.util.List;

public interface OrdersService {
    List<OrdersVo> findAll(Integer pageNum, Integer pageSize) throws  Exception;

    OrdersDetailsVo findOrdersDetails(String id) throws  Exception;
}
