package com.scxh.ssm.dao;

import com.scxh.ssm.domain.OrdersDetailsVo;
import com.scxh.ssm.domain.OrdersVo;

import java.util.List;

public interface OrdersMapper {
    List<OrdersVo> findAll() throws Exception;

    OrdersDetailsVo findOrdersDetails(String id) throws  Exception;
}
