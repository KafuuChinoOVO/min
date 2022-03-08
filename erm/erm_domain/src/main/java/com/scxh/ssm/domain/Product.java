package com.scxh.ssm.domain;

import java.util.Date;


import com.scxh.ssm.uitls.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

@Component
public class Product {
	private String id;         
	private String productNum; //商品编号                            
	private String productName; //商品名                         
	private String cityName;//出发城市
	//从前端接收String自动转换为Date
	@DateTimeFormat(pattern = "yyyy-MM-dd hh:mm")
	private Date departureTime;//出发时间Date类型
	private String departureTimeStr;//出发时间string类型
    private double productPrice;//商品价格                       
	private String productDesc;//商品描述                        
	private int productStatus;//商品状态  关闭0  开启1                          
	private String productStatusStr;//商品中文显示状态
	
	public Product() {
		super();
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getProductNum() {
		return productNum;
	}
	public void setProductNum(String productNum) {
		this.productNum = productNum;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public Date getDepartureTime() {
		return departureTime;
	}
	public void setDepartureTime(Date departureTime) {
		this.departureTime = departureTime;
	}
	public String getDepartureTimeStr() {
		if(departureTime != null) {
			departureTimeStr = DateUtils.date2String(departureTime, "yyyy-MM-dd hh:mm:ss");
		}
		return departureTimeStr;
	}
	public void setDepartureTimeStr(String departureTimeStr) {
		this.departureTimeStr = departureTimeStr;
	}
	public double getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}
	public String getProductDesc() {
		return productDesc;
	}
	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}
	public int getProductStatus() {
		return productStatus;
	}
	public void setProductStatus(int productStatus) {
		this.productStatus = productStatus;
	}
	public String getProductStatusStr() {
			if(productStatus == 0) {
				productStatusStr = "关闭";
			}if(productStatus == 1) {
				productStatusStr = "开启";
			}
			return productStatusStr;
	}
	public void setProductStatusStr(String productStatusStr) {
		this.productStatusStr = productStatusStr;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", productNum=" + productNum + ", productName=" + productName + ", cityName="
				+ cityName + ", departureTime=" + departureTime + ", departureTimeStr=" + departureTimeStr
				+ ", productPrice=" + productPrice + ", productDesc=" + productDesc + ", productStatus=" + productStatus
				+ ", productStatusStr=" + productStatusStr + "]";
	}
	
	
}
