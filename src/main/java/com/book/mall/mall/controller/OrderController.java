package com.book.mall.mall.controller;

import com.book.mall.mall.entity.Goods;
import com.book.mall.mall.entity.Order;
import com.book.mall.mall.reqform.GoodsFindReqForm;
import com.book.mall.mall.reqform.OrderAddReqForm;
import com.book.mall.mall.reqform.OrderConfirmReqForm;
import com.book.mall.mall.reqform.OrderDelReqForm;
import com.book.mall.mall.resbean.OrderAddResBean;
import com.book.mall.mall.resbean.OrderConfirmResBean;
import com.book.mall.mall.resbean.OrderDelResBean;
import com.book.mall.mall.resbean.OrderListResBean;
import com.book.mall.mall.service.GoodsService;
import com.book.mall.mall.service.OrderService;
import com.sun.org.apache.regexp.internal.RE;
import jdk.nashorn.internal.ir.BreakableNode;
import jdk.nashorn.internal.ir.ContinueNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
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

    @RequestMapping(value = "/get/goods", method = RequestMethod.GET)
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
            resBeanList.add(orderService.confirm(id));
        });

        resBeanList.forEach(res -> {
            if(res.getCode() == 0) {
                return;
            }
            resBean.setCode(1);
            resBean.setMsg("商品" + res.getId() + "未结算成功，请刷新后重新结算");
            return;
        });
        return resBean;
    }

    @RequestMapping("/list")
    public OrderListResBean findAll(@Param("openId") String openId) {
        return orderService.findAll(openId);
    }

//    @RequestMapping("/list")
//    public List<Order> findAll() {
//        return orderService.findAll();
//    }

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
