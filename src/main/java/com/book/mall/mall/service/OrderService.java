package com.book.mall.mall.service;

import com.book.mall.mall.entity.Order;
import com.book.mall.mall.mapper.OrderMapper;
import com.book.mall.mall.reqform.OrderAddReqForm;
import com.book.mall.mall.reqform.OrderConfirmReqForm;
import com.book.mall.mall.resbean.OrderAddResBean;
import com.book.mall.mall.resbean.OrderConfirmResBean;
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

    public OrderConfirmResBean getGoods(Long id){
        OrderConfirmResBean resBean = new OrderConfirmResBean();
        resBean.setCode(0);
        resBean.setMsg("确认成功");

        Order order = orderMapper.getById(id);
        if(order == null) {
            resBean.setCode(1);
            resBean.setMsg("确认失败");
            return resBean;
        }

        if(!"已发货".equals(order.getStatus())){
            resBean.setCode(1);
            resBean.setMsg("当前状态不能确认收货");
            return resBean;
        }

        orderMapper.confirm(id, "确认收货");

        return resBean;
    }

    public OrderConfirmResBean sendGoods(Long id){
        OrderConfirmResBean resBean = new OrderConfirmResBean();

        resBean.setCode(0);
        resBean.setMsg("确认成功");

        Order order = orderMapper.getById(id);
        if(order == null) {
            resBean.setCode(1);
            resBean.setMsg("确认失败");
            return resBean;
        }

        if(!"已付款".equals(order.getStatus())){
            resBean.setCode(1);
            resBean.setMsg("当前状态不能发货");
            return resBean;
        }
        orderMapper.confirm(id, "已发货");

        return resBean;
    }

    public OrderConfirmResBean confirm(OrderConfirmReqForm reqForm){
        OrderConfirmResBean resBean = new OrderConfirmResBean();
        resBean.setCode(0);
        resBean.setMsg("确认成功");

        orderMapper.confirm(reqForm.getId(), "已付款");
        return resBean;
    }

    public OrderAddResBean add(OrderAddReqForm reqForm) {
        OrderAddResBean resBean = new OrderAddResBean();
        resBean.setCode(0);
        resBean.setMsg("添加成功");

        reqForm.setStatus("未付款");
        reqForm.setPriceTotal(reqForm.getPrice()*reqForm.getNumber());
        reqForm.setCreateTime(Instant.now().toEpochMilli());
        orderMapper.add(reqForm);
        return resBean;
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
