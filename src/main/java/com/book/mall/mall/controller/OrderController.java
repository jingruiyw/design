package com.book.mall.mall.controller;

import com.book.mall.mall.entity.Goods;
import com.book.mall.mall.entity.Order;
import com.book.mall.mall.reqform.GoodsFindReqForm;
import com.book.mall.mall.reqform.OrderAddReqForm;
import com.book.mall.mall.reqform.OrderDelReqForm;
import com.book.mall.mall.resbean.OrderAddResBean;
import com.book.mall.mall.resbean.OrderConfirmResBean;
import com.book.mall.mall.resbean.OrderDelResBean;
import com.book.mall.mall.service.GoodsService;
import com.book.mall.mall.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

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
    public OrderConfirmResBean confirm() {
        // todo 确认接口待定
        return null;
    }

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

        //商品存在库存是否充足, 此时未修改商品表，确认付款之后，再更改商品表
        Goods good = goods.get(0);
        if(good.getNumber() < reqForm.getNumber()) {
            resBean.setCode(1);
            resBean.setMsg("库存不足, 请修改购买数量");
            return resBean;
        }

        return orderService.add(reqForm);
    }

}
