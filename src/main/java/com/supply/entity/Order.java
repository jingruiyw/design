package com.supply.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author Deniecece
 * @since 2019-04-16
 */
public class Order implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 关联用户表唯一标识
     */
    private String openId;

    /**
     * 关联商品名称
     */
    private String supplyNo;

    /**
     * 订单状态，默认：未付款，确认：已付款
     */
    private String status;

    /**
     * 商品总价
     */
    private Double price;

    /**
     * 创建时间
     */
    private Integer createTime;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getSupplyNo() {
        return supplyNo;
    }

    public void setSupplyNo(String supplyNo) {
        this.supplyNo = supplyNo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Integer createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Order{" +
        "id=" + id +
        ", openId=" + openId +
        ", supplyNo=" + supplyNo +
        ", status=" + status +
        ", price=" + price +
        ", createTime=" + createTime +
        "}";
    }
}
