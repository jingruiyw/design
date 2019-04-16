package com.book.mall.mall.reqform;

import javax.validation.constraints.NotBlank;

public class AddressUpdateReqForm {

    @NotBlank(message = "id不能为空")
    private String id;
    @NotBlank(message = "openId不能为空")
    private String openId;
    @NotBlank(message = "名称不能为空")
    private String name;
    @NotBlank(message = "收货地址不能为空")
    private String address;
    @NotBlank(message = "电话号码不能为空")
    private String mobileNo;
    private String createTime;

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

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
