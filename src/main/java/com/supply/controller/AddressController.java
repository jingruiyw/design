package com.supply.controller;

import com.supply.core.KkbResponse;
import com.supply.entity.Address;
import com.supply.entity.User;
import com.supply.domain.DoAddress;
import com.supply.service.IAddressService;
import com.supply.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class AddressController {

    @Autowired
    IAddressService iAddressService;
    @Autowired
    IUserService iUserService;

    /**
     * 详情
     */
    @GetMapping("/address/{id}")
    public Address getDetails(@PathVariable Integer id) {
        return iAddressService.getDetails(id);
    }

    /**
     * 列表
     */
    @GetMapping("/address/list")
    public List<Address> getList(@RequestParam(name = "openId") String openId) {
        Object user = iUserService.getByOpenId(openId).getData();
        if(user == null) {
            return null;
        }
        return iAddressService.selectByOpenId(openId);
    }
    /**
     * 添加
     */
    @PostMapping("/address")
    public KkbResponse addAddress(@RequestBody @Valid DoAddress doAddress){
        return iAddressService.addAddress(doAddress);
    }

    /**
     * 修改
     */
    @PutMapping("/address")
    public KkbResponse updateAddress(@RequestBody @Valid DoAddress reqForm){
        return iAddressService.updateAddress(reqForm);
    }

    /**
     * 删除
     */
    @DeleteMapping("/address/{id}")
    public KkbResponse delAddress(@PathVariable String id){
        return iAddressService.delAddress(id);
    }
}
