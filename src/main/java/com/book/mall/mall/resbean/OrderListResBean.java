package com.book.mall.mall.resbean;


import com.book.mall.mall.entity.Order;

import java.util.List;

public class OrderListResBean extends Order{

    List<Order> orderList;
    private String userName;
    private String address;

    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
