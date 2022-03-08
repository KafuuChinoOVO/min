package com.scxh.ssm.domain;


import com.scxh.ssm.uitls.DateUtils;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class OrdersVo {
    private String id;
    private String orderNum;
    private Date orderTime;  //时间
    private String orderTimeStr;
    private int orderStatus;
    private String productName;
    private double productPrice;
    private String orderStatusStr; //判断支付没有
    public String getOrderStatusStr() {
        //订单状态(0 未支付 1 已支付)
        if(orderStatus==0){
            orderStatusStr="未支付";
        }else if(orderStatus==1){
            orderStatusStr="已支付";
        }
        return orderStatusStr;
    }

    public void setOrderStatusStr(String orderStatusStr) {
        this.orderStatusStr = orderStatusStr;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public String getOrderTimeStr() {
        if(orderTime != null) {
            orderTimeStr = DateUtils.date2String(orderTime, "yyyy-MM-dd hh:mm:ss");
        }
        return orderTimeStr;
    }
    public int getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(int orderStatus) {
        this.orderStatus = orderStatus;
    }
    public String getProductName() {
        return productName;
    }
    public void setProductName(String productName) {
        this.productName = productName;
    }
    public double getProductPrice() {
        return productPrice;
    }
    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    @Override
    public String toString() {
        return "OrdersVo{" +
                "id='" + id + '\'' +
                ", orderNum='" + orderNum + '\'' +
                ", orderTime=" + orderTime +
                ", orderTimeStr='" + orderTimeStr + '\'' +
                ", orderStatus=" + orderStatus +
                ", productName='" + productName + '\'' +
                ", productPrice=" + productPrice +
                ", orderStatusStr='" + orderStatusStr + '\'' +
                '}';
    }
}
