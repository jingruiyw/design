package com.book.mall.mall.controller;

import com.book.mall.mall.entity.Goods;
import com.book.mall.mall.reqform.*;
import com.book.mall.mall.resbean.OrderAddResBean;
import com.book.mall.mall.resbean.OrderConfirmResBean;
import com.book.mall.mall.resbean.OrderDelResBean;
import com.book.mall.mall.resbean.OrderListResBean;
import com.book.mall.mall.service.GoodsService;
import com.book.mall.mall.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;
    @Autowired
    GoodsService goodsService;

    @RequestMapping(value = "/get/goods", method = RequestMethod.POST)
    public OrderConfirmResBean getGoods(@Param("id") Long id) {
        OrderConfirmResBean resBean = new OrderConfirmResBean();
        if(id == null) {
            resBean.setCode(1);
            resBean.setMsg("id不能为空");
            return resBean;
        }

        return orderService.getGoods(id);
    }

    @RequestMapping(value = "/send/goods", method = RequestMethod.GET)
    public OrderConfirmResBean sendGoods(@Param("id") Long id) {
        OrderConfirmResBean resBean = new OrderConfirmResBean();
        if(id == null) {
            resBean.setCode(1);
            resBean.setMsg("id不能为空");
            return resBean;
        }

        return orderService.sendGoods(id);
    }

    @Transactional
    @RequestMapping(value = "/confirm", method = RequestMethod.POST)
    public OrderConfirmResBean confirm(@RequestBody @Valid OrderConfirmReqForm reqForm) {
        OrderConfirmResBean resBean = new OrderConfirmResBean();
        resBean.setCode(0);
        resBean.setMsg("购买成功");

        List<Long> idList = reqForm.getIdList();
        if(idList == null || idList.size() == 0) {
            resBean.setCode(1);
            resBean.setMsg("id不能为空");
            return resBean;
        }

        List<OrderConfirmResBean> resBeanList = new ArrayList<>();
        idList.forEach(id -> {
            resBeanList.add(orderService.confirm(id, reqForm.getAddressId()));
        });

        try{
            resBeanList.forEach(res -> {
                if(res.getCode() != 0) {
                    resBean.setCode(res.getCode());
                    resBean.setMsg("该商品" + res.getMsg());
                    resBean.setId(res.getId());
                    throw new RuntimeException(resBean.getMsg() + "抛异常了");
                }
            });
        }catch (RuntimeException e) {
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return resBean;
        }
        return resBean;
    }

    @RequestMapping("/list/openId")
    public OrderListResBean find(@Param("openId") String openId, @Param("status") Integer status) {

        String statusMsg;

        switch (status) {
            case 0:
                statusMsg = "未付款";
                break;
            case 1:
                statusMsg = "已付款";
                break;
            case 2:
                statusMsg = "已发货";
                break;
            case 3:
                statusMsg = "已完成";
                break;
            default:
                statusMsg = "";
        }

        return orderService.find(openId, statusMsg);
    }

    @RequestMapping("/list")
    public OrderListResBean findAll() {
        return orderService.findAll();
    }

    @RequestMapping(value = "/del/batch", method = RequestMethod.POST)
    public OrderDelResBean delBatch(@RequestBody OrderDelBatchReqForm reqForm) {
        OrderDelResBean resBean = new OrderDelResBean();
        resBean.setCode(0);
        resBean.setMsg("删除成功");
        List<Long> idList = reqForm.getIdList();

        idList.forEach(id -> {
            orderService.del(id);
        });

        return resBean;
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

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public OrderAddResBean add(@RequestBody OrderAddReqForm reqForm) {
        OrderAddResBean resBean = new OrderAddResBean();
        resBean.setCode(0);
        resBean.setMsg("添加成功");

        if(reqForm.getOpenId() == null) {
            resBean.setCode(1);
            resBean.setMsg("openId不能为空");
            return resBean;
        }

        if(reqForm.getGoodsName() == null) {
            resBean.setCode(1);
            resBean.setMsg("商品名称不能为空");
            return resBean;
        }

        if(reqForm.getGoodsKind() == null) {
            resBean.setCode(1);
            resBean.setMsg("商品种类不能为空");
            return resBean;
        }

        if(reqForm.getAddressId() == null) {
            reqForm.setAddressId(1L);
        }


        String name = reqForm.getGoodsName();
        String kind = reqForm.getGoodsKind();
        GoodsFindReqForm req = new GoodsFindReqForm();
        req.setName(name);
        req.setKind(kind);
        List<Goods> goods = goodsService.findByConditions(req);

        //判断商品是否存在
        if(goods == null || goods.size() == 0) {
            resBean.setCode(1);
            resBean.setMsg("该商品不存在");
            return resBean;
        }

        return orderService.add(reqForm);
    }

}
