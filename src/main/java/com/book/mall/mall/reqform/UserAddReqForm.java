package com.book.mall.mall.reqform;

import javax.validation.constraints.NotBlank;

public class UserAddReqForm {

    private Long id;
    @NotBlank(message = "openId不能为空")
    private String openId;
    @NotBlank(message = "名称不能为空")
    private String name;
    @NotBlank(message = "头像不能为空")
    private String image;
    private Long createTime;

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
