package com.book.mall.mall.mapper;

import com.book.mall.mall.entity.Order;
import com.book.mall.mall.reqform.OrderAddReqForm;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface OrderMapper {

    @Select("select * from order_t")
    public List<Order> findAll();

    @Delete("delete from order_t where id = #{id}")
    public void del(@Param("id") Long id);

    @Insert("insert into order_t (open_id, goods_name, goods_kind, status, number, price, price_total, create_time) values " +
            "(#{openId}, #{goodsName}, #{goodsKind}, #{status}, #{number}, #{price}, #{priceTotal}, #{createTime})")
    public void add(OrderAddReqForm reqForm);

}
