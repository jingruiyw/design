package com.book.mall.mall.resbean;

import java.util.List;

public class OrderListResBean{

    List<OrderEntity> orderList;

    public List<OrderEntity> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<OrderEntity> orderList) {
        this.orderList = orderList;
    }

    public static class OrderEntity{
        private Long id;
        private String openId;
        private String goodsName;
        private String goodsKind;
        private String status;
        private Integer number;
        private Double price;
        private Double priceTotal;
        private String createTime;
        private String userName;
        private String address;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getOpenId() {
            return openId;
        }

        public void setOpenId(String openId) {
            this.openId = openId;
        }

        public String getGoodsName() {
            return goodsName;
        }

        public void setGoodsName(String goodsName) {
            this.goodsName = goodsName;
        }

        public String getGoodsKind() {
            return goodsKind;
        }

        public void setGoodsKind(String goodsKind) {
            this.goodsKind = goodsKind;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public Integer getNumber() {
            return number;
        }

        public void setNumber(Integer number) {
            this.number = number;
        }

        public Double getPrice() {
            return price;
        }

        public void setPrice(Double price) {
            this.price = price;
        }

        public Double getPriceTotal() {
            return priceTotal;
        }

        public void setPriceTotal(Double priceTotal) {
            this.priceTotal = priceTotal;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
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
}
