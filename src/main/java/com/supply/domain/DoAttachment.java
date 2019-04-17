package com.supply.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author Deniecece
 * @since 2019-04-16
 */
public class DoAttachment implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    @NotBlank(message = "商品id不能为空")
    private Integer supplyId;

    @NotBlank(message = "图片不能为空")
    private String url;

    private Integer createTime;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSupplyId() {
        return supplyId;
    }

    public void setSupplyId(Integer supplyId) {
        this.supplyId = supplyId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Integer createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Attachment{" +
        "id=" + id +
        ", supplyId=" + supplyId +
        ", url=" + url +
        ", createTime=" + createTime +
        "}";
    }
}
