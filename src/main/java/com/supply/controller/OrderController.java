package com.supply.controller;


import com.supply.core.KkbPage;
import com.supply.core.KkbResponse;
import com.supply.core.KkbStatus;
import com.supply.domain.DoOrder;
import com.supply.service.IOrderService;
import com.supply.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Deniecece
 * @since 2019-04-16
 */
@RestController
public class OrderController {

    @Autowired
    IOrderService iOrderService;
    @Autowired
    IUserService iUserService;

    /**
     * 详情
     */
    @GetMapping("/order/{id}")
    public KkbResponse getDetails(@PathVariable Integer id) {
        return iOrderService.getDetails(id);
    }

    /**
     * 列表
     */
    @PostMapping("/order/list")
    public KkbResponse getList(@RequestParam(name = "openId", required = false) String openId,
                               @RequestBody(required = false)KkbPage kkbPage) {
        Object user = iUserService.getByOpenId(openId);
        if(user == null) {
            return new KkbResponse(KkbStatus.NO_DATA.getCode(), "用户不存在");
        }
        return iOrderService.selectByOpenId(openId, kkbPage);
    }
    /**
     * 添加
     */
    @PostMapping("/order")
    public KkbResponse addOrder(@RequestBody @Valid DoOrder doOrder){
        return iOrderService.addOrder(doOrder);
    }

    /**
     * 修改状态
     */
    @PutMapping("/order")
    public KkbResponse updateOrder(@RequestBody @Valid DoOrder doOrder) {
        return iOrderService.updateOrder(doOrder);
    }
    /**
     * 删除
     */
    @DeleteMapping("/order/{id}")
    public KkbResponse delOrder(@PathVariable String id){
        return iOrderService.delOrder(id);
    }
}

