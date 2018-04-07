package com.beans;

import java.io.Serializable;
import java.util.Date;

public class Order implements Serializable{
    /*private int orderImage;*/
    private Integer orderId;
    private ConsumerBean consumerBean;
    private ShopkeeperBean shopkeeperBean;
    private Date orderDate;
    private Double orderAmount;
    private String orderItems;
    private String orderStatus;

    public Order( Integer orderId, ConsumerBean consumerBean, ShopkeeperBean shopkeeperBean, Date orderDate, Double orderAmount, String orderItems, String orderStatus) {
       /* this.orderImage = orderImage;*/
        this.orderId = orderId;
        this.consumerBean = consumerBean;
        this.shopkeeperBean = shopkeeperBean;
        this.orderDate = orderDate;
        this.orderAmount = orderAmount;
        this.orderItems = orderItems;
        this.orderStatus = orderStatus;
    }

   /* public int getOrderImage() {
        return orderImage;
    }

    public void setOrderImage(int orderImage) {
        this.orderImage = orderImage;
    }*/

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public ConsumerBean getConsumerBean() {
        return consumerBean;
    }

    public void setConsumerBean(ConsumerBean consumerBean) {
        this.consumerBean = consumerBean;
    }

    public ShopkeeperBean getShopkeeperBean() {
        return shopkeeperBean;
    }

    public void setShopkeeperBean(ShopkeeperBean shopkeeperBean) {
        this.shopkeeperBean = shopkeeperBean;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Double getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(Double orderAmount) {
        this.orderAmount = orderAmount;
    }

    public String getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(String orderItems) {
        this.orderItems = orderItems;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }
}
