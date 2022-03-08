package com.scxh.ssm.controller;

import com.github.pagehelper.PageInfo;
import com.scxh.ssm.domain.OrdersDetailsVo;
import com.scxh.ssm.domain.OrdersVo;
import com.scxh.ssm.service.OrdersService;
import com.scxh.ssm.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrdersController {
    @Autowired
    private OrdersService os;

    @RequestMapping("findAll")
    public String findAll(Model model,
                          @RequestParam(value = "pageNum", required = true, defaultValue = "1") Integer pageNum,
                          @RequestParam(value = "pageSize", required = true, defaultValue = "5") Integer pageSize)
            throws Exception{
        List<OrdersVo> list = os.findAll(pageNum, pageSize);
        for (OrdersVo vo: list ) {
            System.out.println(vo.getOrderTime()+"======="+vo.getOrderTimeStr());

        }
        PageInfo<OrdersVo> pageInfo = new PageInfo<OrdersVo>(list);
        System.out.println("============" + pageInfo + "==============");
        model.addAttribute("pageInfo",pageInfo);
        return "orders-page-list";
    }

    @RequestMapping("/OrdersDetails")
    public String OrdersDetails(String id,Model model) throws  Exception{
        OrdersDetailsVo ordersDetails = os.findOrdersDetails(id);
        System.out.println("============" + ordersDetails + "==============");
        model.addAttribute("OrdersDetailsVo",ordersDetails);
        return "orders-show";

    }


}
