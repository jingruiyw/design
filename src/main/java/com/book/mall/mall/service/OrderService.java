package com.book.mall.mall.service;

import com.book.mall.mall.entity.Address;
import com.book.mall.mall.entity.Goods;
import com.book.mall.mall.entity.Order;
import com.book.mall.mall.mapper.AddressMapper;
import com.book.mall.mall.mapper.GoodsMapper;
import com.book.mall.mall.mapper.OrderMapper;
import com.book.mall.mall.reqform.GoodsFindReqForm;
import com.book.mall.mall.reqform.OrderAddReqForm;
import com.book.mall.mall.resbean.OrderAddResBean;
import com.book.mall.mall.resbean.OrderConfirmResBean;
import com.book.mall.mall.resbean.OrderDelResBean;
import com.book.mall.mall.resbean.OrderListResBean;
import com.book.mall.mall.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private GoodsMapper goodsMapper;
    @Autowired
    private AddressMapper addressMapper;
//    @Autowired
//    private UserMapper userMapper;

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

        orderMapper.confirm(id, "已完成", order.getAddressId());

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
        orderMapper.confirm(id, "已发货", order.getAddressId());

        return resBean;
    }

    public OrderConfirmResBean confirm(Long id, Long addressId){
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
            resBean.setId(id);
            resBean.setMsg("该商品不存在");
            return resBean;
        }

        //商品存在库存是否充足
        Goods good = goods.get(0);
        if(good.getNumber() < order.getNumber()) {
            resBean.setCode(1);
            resBean.setId(id);
            resBean.setMsg("库存为: <" + good.getNumber() + ">库存不足, 请修改购买数量");
            return resBean;
        }

        if(!"未付款".equals(order.getStatus())) {
            resBean.setCode(1);
            resBean.setId(id);
            resBean.setMsg( ": <" + order.getStatus() +">状态不能付款");
            return resBean;
        }

        //修改商品的库存和更新地址信息
        Integer newNum = good.getNumber() - order.getNumber();
        goodsMapper.changeNum(newNum, good.getId());
        orderMapper.confirm(id, "已付款", addressId);

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

    public OrderListResBean find(String openId, String status){
        OrderListResBean resBean = new OrderListResBean();

        List<Order> orders = orderMapper.find(openId, status);
        List<OrderListResBean.OrderEntity> entityList = new ArrayList<>();

        for(Order order : orders) {
            OrderListResBean.OrderEntity entity = new OrderListResBean.OrderEntity();
            entity.setId(order.getId());
            entity.setOpenId(openId);
            entity.setGoodsName(order.getGoodsName());
            entity.setGoodsKind(order.getGoodsKind());
            entity.setStatus(order.getStatus());
            entity.setNumber(order.getNumber());
            entity.setPrice(order.getPrice());
            entity.setPriceTotal(order.getPriceTotal());
            entity.setCreateTime(DateUtil.formatDate(Long.parseLong(order.getCreateTime())));
            entity.setOrderNo(order.getCreateTime());

            Address address = addressMapper.selectById(order.getAddressId());

            if(address == null) {
                entity.setAddress("该地址已被删除");
                entity.setUserName("该用户已被删除");
            }

            if(address != null) {
                entity.setAddress(address.getAddress());
                entity.setUserName(address.getName());
            }

//            entity.setUserName(userMapper.selectByOpenId(openId).getName());
//            entity.setAddress(addressMapper.selectById(order.getAddressId()).getAddress());

            entityList.add(entity);
        }
        resBean.setOrderList(entityList);
        return resBean;
    }

    public OrderListResBean findAll(){
        OrderListResBean resBean = new OrderListResBean();
        List<Order> orders = orderMapper.findAll();
        List<OrderListResBean.OrderEntity> entityList = new ArrayList<>();

        for(Order order : orders) {
            OrderListResBean.OrderEntity entity = new OrderListResBean.OrderEntity();
            entity.setId(order.getId());
            entity.setOpenId(order.getOpenId());
            entity.setGoodsName(order.getGoodsName());
            entity.setGoodsKind(order.getGoodsKind());
            entity.setStatus(order.getStatus());
            entity.setNumber(order.getNumber());
            entity.setPrice(order.getPrice());
            entity.setPriceTotal(order.getPriceTotal());
            entity.setCreateTime(DateUtil.formatDate(Long.parseLong(order.getCreateTime())));
            entity.setOrderNo(order.getCreateTime());
            order.setCreateTime(DateUtil.formatDate(Long.parseLong(order.getCreateTime())));
            Address address = addressMapper.selectById(order.getAddressId());

            if(address == null) {
                entity.setAddress("该地址已被删除");
                entity.setUserName("该用户已被删除");
            }

            if(address != null) {
                entity.setAddress(address.getAddress());
                entity.setUserName(address.getName());
            }
            entityList.add(entity);
        }
        resBean.setOrderList(entityList);
        return resBean;
    }

    public OrderDelResBean del(Long id) {
        OrderDelResBean resBean = new OrderDelResBean();
        resBean.setCode(0);
        resBean.setMsg("删除成功");

        Order order = orderMapper.getById(id);
        if(order == null) {
            return resBean;
        }

        String status = order.getStatus();
        if("已付款".equals(status) || "已发货".equals(status)) {
            resBean.setCode(1);
            resBean.setMsg("该状态订单不能删除");
            return resBean;
        }

        orderMapper.del(id);

        return resBean;
    }
}
