package com.book.mall.mall.controller;

import com.book.mall.mall.entity.Address;
import com.book.mall.mall.entity.User;
import com.book.mall.mall.reqform.AddressAddReqForm;
import com.book.mall.mall.reqform.AddressUpdateReqForm;
import com.book.mall.mall.resbean.AddressResBean;
import com.book.mall.mall.service.AddressService;
import com.book.mall.mall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class AddressController {

    @Autowired
    AddressService addressService;
    @Autowired
    UserService userService;

    /**
     * 详情
     */
    @GetMapping("/address/{id}")
    public Address getDetails(@PathVariable String id) {
        return addressService.getDetails(id);
    }

    /**
     * 列表
     */
    @GetMapping("/address/list")
    public List<Address> getList(@RequestParam(name = "openId") String openId) {
        User user = userService.getByOpenId(openId);
        if(user == null) {
            return null;
        }
        return addressService.selectByOpenId(openId);
    }
    /**
     * 添加
     */
    @PostMapping("/address")
    public AddressResBean addAddress(@RequestBody @Valid AddressAddReqForm reqForm){
        return addressService.addAddress(reqForm);
    }

    /**
     * 修改
     */
    @PutMapping("/address")
    public AddressResBean updateAddress(@RequestBody AddressUpdateReqForm reqForm){
        return addressService.updateAddress(reqForm);
    }

    /**
     * 删除
     */
    @DeleteMapping("/address/{id}")
    public AddressResBean delAddress(@PathVariable String id){
        return addressService.delAddress(id);
    }
}
