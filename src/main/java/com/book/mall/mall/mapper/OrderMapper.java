package com.book.mall.mall.mapper;

import com.book.mall.mall.entity.Order;
import com.book.mall.mall.reqform.OrderAddReqForm;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface OrderMapper {

    @Select("select * from order_t where id = #{id}")
    public Order getById(@Param("id") Long id);

    @Select("select * from order_t")
    public List<Order> findAll();

    @Select("select * from order_t where status like #{status} and open_id = #{openId}")
    public List<Order> find(@Param("openId") String openId, @Param("status") String status);

    @Delete("delete from order_t where id = #{id}")
    public void del(@Param("id") Long id);

    @Insert("insert into order_t (open_id, address_id, goods_name, goods_kind, status, number, price, price_total, create_time) values " +
            "(#{openId}, #{addressId}, #{goodsName}, #{goodsKind}, #{status}, #{number}, #{price}, #{priceTotal}, #{createTime})")
    public void add(OrderAddReqForm reqForm);

    @Update("update order_t set status = #{status} address_id = #{addressId} where id = #{id}")
    public void confirm(@Param("id")Long id, @Param("status") String status, @Param("addressId") Long addressId);

}
