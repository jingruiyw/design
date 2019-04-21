package com.book.mall.mall.service;

import com.book.mall.mall.entity.Goods;
import com.book.mall.mall.entity.Order;
import com.book.mall.mall.mapper.GoodsMapper;
import com.book.mall.mall.mapper.OrderMapper;
import com.book.mall.mall.reqform.GoodsFindReqForm;
import com.book.mall.mall.reqform.OrderAddReqForm;
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
    @Autowired
    private GoodsMapper goodsMapper;

    public Order getById(Long id){
        return orderMapper.getById(id);
    }

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

    public OrderConfirmResBean confirm(Long id){
        OrderConfirmResBean resBean = new OrderConfirmResBean();
        resBean.setCode(0);
        resBean.setMsg("确认成功");

        Order order = orderMapper.getById(id);
        resBean.setId(order.getId());

        String name = order.getGoodsName();
        String kind = order.getGoodsKind();
        GoodsFindReqForm req = new GoodsFindReqForm();
        req.setName(name);
        req.setKind(kind);
        List<Goods> goods = goodsMapper.findByConditions(req);

        //判断商品是否存在
        if(goods == null || goods.size() == 0) {
            resBean.setCode(1);
            resBean.setMsg("该商品不存在");
            return resBean;
        }

        //商品存在库存是否充足
        Goods good = goods.get(0);
        if(good.getNumber() < order.getNumber()) {
            resBean.setCode(1);
            resBean.setMsg("库存不足, 请修改购买数量");
            return resBean;
        }

        //修改商品的库存
        Integer newNum = good.getNumber() - order.getNumber();
        goodsMapper.changeNum(newNum, good.getId());
        orderMapper.confirm(id, "已付款");

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
