package com.book.mall.mall.service;

import com.book.mall.mall.entity.Order;
import com.book.mall.mall.mapper.OrderMapper;
import com.book.mall.mall.reqform.OrderAddReqForm;
import com.book.mall.mall.resbean.OrderAddResBean;
import com.book.mall.mall.resbean.OrderDelResBean;
import com.book.mall.mall.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderMapper orderMapper;

    public OrderAddResBean add(OrderAddReqForm reqForm) {
        OrderAddResBean resBean = new OrderAddResBean();
        resBean.setCode(0);
        resBean.setMsg("添加成功");

        //todo 添加方法暂存
        reqForm.setCreateTime(Instant.now().toEpochMilli());
        orderMapper.add(reqForm);
        return null;
    }

    public List<Order> findAll(){
        List<Order> orders = orderMapper.findAll();
        for(Order order : orders) {
            order.setCreateTime(DateUtil.formatDate(Long.parseLong(order.getCreateTime())));
        }
        return orders;
    }

    public OrderDelResBean del(Long id) {
        OrderDelResBean resBean = new OrderDelResBean();
        resBean.setCode(0);
        resBean.setMsg("删除成功");
        orderMapper.del(id);

        return resBean;
    }
}
