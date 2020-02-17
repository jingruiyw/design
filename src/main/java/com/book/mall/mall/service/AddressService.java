package com.book.mall.mall.service;

import com.book.mall.mall.entity.Address;
import com.book.mall.mall.mapper.AddressMapper;
import com.book.mall.mall.reqform.AddressAddReqForm;
import com.book.mall.mall.reqform.AddressUpdateReqForm;
import com.book.mall.mall.resbean.AddressResBean;
import com.book.mall.mall.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.time.Instant;
import java.util.List;

@Service
public class AddressService {

    @Autowired
    AddressMapper addressMapper;

    public Address getDetails(Long id) {
        if(StringUtils.isEmpty(id)) {
            return null;
        }
        Address address = addressMapper.selectById(id);
        if(address != null) {
            address.setCreateTime(DateUtil.formatDate(Long.parseLong(address.getCreateTime())));
        }
        return address;
    }

    public List<Address> selectByOpenId(String openId) {
        List<Address> addresses = addressMapper.selectList(openId);
        if(!CollectionUtils.isEmpty(addresses)) {
            addresses.forEach(address ->
                address.setCreateTime(DateUtil.formatDate(Long.parseLong(address.getCreateTime()))));
        }
        return addresses;
    }

    public AddressResBean addAddress(AddressAddReqForm reqForm) {
        Address address = addressMapper.selectOne(reqForm.getOpenId(), reqForm.getMobileNo(), reqForm.getName(), reqForm.getAddress());
        if(address == null) {
            reqForm.setCreateTime(Instant.now().toEpochMilli());
            int result = addressMapper.insert(reqForm);
            if(result == 1) {
                return new AddressResBean(0, "添加地址成功");
            }
            return new AddressResBean(1, "添加地址失败");

        }
        return new AddressResBean(3, "该地址已存在");
    }

    public AddressResBean updateAddress(AddressUpdateReqForm reqForm) {
        Address address = this.getDetails(Long.parseLong(reqForm.getId()));
        if(address != null) {
            int result = addressMapper.updateAddress(reqForm);
            if(result == 1) {
                return new AddressResBean(0, "更新地址成功");
            }
            return new AddressResBean(1, "更新地址失败");
        }
        return new AddressResBean(4, "该地址不存在");
    }

    public AddressResBean delAddress(Long id) {
        Address address = this.getDetails(id);
        if(address != null) {
            int result = addressMapper.delAddress(id);
            if(result == 1) {
                return new AddressResBean(0, "删除地址成功");
            }
            return new AddressResBean(1, "删除地址失败");
        }
        return new AddressResBean(4, "该地址不存在");
    }

}
