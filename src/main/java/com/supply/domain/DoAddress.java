package com.supply.domain;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

public class DoAddress {

    private String id;
    @NotBlank(message = "openId不能为空")
    private String openId;
    @NotBlank(message = "名称不能为空")
    private String name;
    @NotBlank(message = "收货地址不能为空")
    private String address;
    @NotBlank(message = "电话号码不能为空")
    private String mobile;
    /**
     * 创建时间
     */
    private Integer createTime;

    private LocalDateTime updateTime;
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Integer getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Integer createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
