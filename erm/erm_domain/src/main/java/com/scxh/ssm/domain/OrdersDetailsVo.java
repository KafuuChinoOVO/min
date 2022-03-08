package com.scxh.ssm.domain;

import com.scxh.ssm.uitls.DateUtils;
import org.springframework.stereotype.Component;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.List;

@Component
public class OrdersDetailsVo {
    private String orderNum;
    private Date orderTime;
    private int peopleCount;
    private String orderDesc;
    private int orderStatus;
    private int payType;
    private String payTypeStr;
    public String getPayTypeStr() {
        //支付方式(0 支付宝 1 微信 2其它)
        if(payType==0){
            payTypeStr="支付宝";
        }else if(payType==1){
            payTypeStr="微信";
        }else if(payType==2){
            payTypeStr="其它";
        }
        return payTypeStr;
    }
    private String productName;
    private String cityName;
    private  Date DepartureTime;
    private  String DepartureTimeStr;
    private int productPrice;
    private String name; //member
    private String nickname;
    private String PHONENUM; //member
    private String email;
    private String orderTimeStr;
    private List<Traveller> travellers;

    public List<Traveller> getTravellers() {
        return travellers;
    }

    public void setTravellers(List<Traveller> travellers) {
        this.travellers = travellers;
    }
    public void setDepartureTimeStr(Date DepartureTime) {
        this.DepartureTime = DepartureTime;
    }

    public String getDepartureTimeStr() {

        if(DepartureTime != null) {
            DepartureTimeStr = DateUtils.date2String(DepartureTime, "yyyy-MM-dd hh:mm:ss");
        }
        return DepartureTimeStr;
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
    public String getOrderNum() {
        return orderNum;
    }

    public int getPeopleCount() {
        return peopleCount;
    }

    public String getOrderDesc() {
        return orderDesc;
    }

    public int getOrderStatus() {
        return orderStatus;
    }

    public int getPayType() {
        return payType;
    }

    public String getProductName() {
        return productName;
    }

    public String getCityName() {
        return cityName;
    }

    public int getProductPrice() {
        return productPrice;
    }




    public String getName() {
        return name;
    }

    public String getNickname() {
        return nickname;
    }

    public String getPHONENUM() {
        return PHONENUM;
    }

    public String getEmail() {
        return email;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public void setPeopleCount(int peopleCount) {
        this.peopleCount = peopleCount;
    }

    public void setOrderDesc(String orderDesc) {
        this.orderDesc = orderDesc;
    }

    public void setOrderStatus(int orderStatus) {
        this.orderStatus = orderStatus;
    }

    public void setPayType(int payType) {
        this.payType = payType;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public void setProductPrice(int productPrice) {
        this.productPrice = productPrice;
    }




    public void setName(String name) {
        this.name = name;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setPHONENUM(String PHONENUM) {
        this.PHONENUM = PHONENUM;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "OrdersDetailsVo{" +
                "orderNum='" + orderNum + '\'' +
                ", orderTime=" + orderTime +
                ", peopleCount=" + peopleCount +
                ", orderDesc='" + orderDesc + '\'' +
                ", orderStatus=" + orderStatus +
                ", payType=" + payType +
                ", productName='" + productName + '\'' +
                ", cityName='" + cityName + '\'' +
                ", DepartureTime=" + DepartureTime +
                ", DepartureTimeStr='" + DepartureTimeStr + '\'' +
                ", productPrice=" + productPrice +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                ", PHONENUM='" + PHONENUM + '\'' +
                ", email='" + email + '\'' +
                ", orderTimeStr='" + orderTimeStr + '\'' +
                ", travellers=" + travellers +
                '}';
    }
}
