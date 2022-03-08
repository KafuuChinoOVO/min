package com.scxh.ssm.service.impl;


import com.github.pagehelper.PageHelper;
import com.scxh.ssm.dao.OrdersMapper;
import com.scxh.ssm.domain.OrdersDetailsVo;
import com.scxh.ssm.domain.OrdersVo;
import com.scxh.ssm.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class OrdersServiceImpl implements OrdersService {
    @Autowired
    private OrdersMapper om;

   @Override
    public List<OrdersVo> findAll(Integer pageNum,Integer pageSize) throws Exception {
       PageHelper.startPage(pageNum,pageSize);
       List<OrdersVo> ordersVos = om.findAll();
       return  ordersVos;
    }

    @Override
    public OrdersDetailsVo findOrdersDetails(String id) throws Exception {
           return om.findOrdersDetails(id);
    }


}
