package com.book.mall.mall.controller;

import com.book.mall.mall.entity.Order;
import com.book.mall.mall.reqform.OrderDelReqForm;
import com.book.mall.mall.resbean.OrderDelResBean;
import com.book.mall.mall.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @RequestMapping("/list")
    public List<Order> findAll() {
        return orderService.findAll();
    }

    @RequestMapping(value = "/del", method = RequestMethod.POST)
    public OrderDelResBean del(@RequestBody OrderDelReqForm reqForm) {
        OrderDelResBean resBean = new OrderDelResBean();
        if (reqForm.getId() == null) {
            resBean.setCode(1);
            resBean.setMsg("id不能为空");
            return resBean;
        }
        return orderService.del(reqForm.getId());
    }


}
