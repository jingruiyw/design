package com.book.mall.mall.reqform;


import javax.validation.constraints.NotNull;
import java.util.List;

public class OrderConfirmReqForm {

    @NotNull(message = "地址必须添加")
    private Long addressId;
    private List<Long> idList;

    public Long getAddressId() {
        return addressId;
    }

    public void setAddressId(Long addressId) {
        this.addressId = addressId;
    }

    public List<Long> getIdList() {
        return idList;
    }

    public void setIdList(List<Long> idList) {
        this.idList = idList;
    }
}
