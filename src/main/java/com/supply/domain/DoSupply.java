package com.supply.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author Deniecece
 * @since 2019-04-16
 */
public class DoSupply implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    @NotBlank(message = "openId不能为空")
    private String openId;
    @NotBlank(message = "名称不能为空")
    private String name;

    /**
     * 商品类型
     */
    @NotBlank(message = "类型不能为空")
    private String type;

    private String image;

    /**
     * 商品描述
     */
    private String description;

    /**
     * 商品价格
     */
    @NotBlank(message = "价格不能为空")
    private BigDecimal price;

    private Integer createTime;

    private LocalDateTime updateTime;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    @Override
    public String toString() {
        return "Supply{" +
        "id=" + id +
        ", name=" + name +
        ", type=" + type +
        ", description=" + description +
        ", price=" + price +
        ", createTime=" + createTime +
        ", updateTime=" + updateTime +
        "}";
    }
}
