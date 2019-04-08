package com.book.mall.mall.mapper;

import com.book.mall.mall.entity.Goods;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

@Component
public interface GoodsMapper {

    @Select("select * from goods where id = #{id}")
    public Goods getById(Long id);

    @Delete("delete from goods where id = #{id}")
    public int delById(Long id);

    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into goods(name, price, number, kind, stock, image, status, remark,createTime) values(#{name}, #{price},#{number},#{kind},#{stock},#{image},#{status},#{remark},#{createTime})")
    public int addGoods(Goods goods);

    @Update("update goods set name= #{name}, price= #{price}, number= #{number}, kind= #{kind}, stock= #{stock}, image=#{image}, status=#{status}, remark=#{remark}, createTime=#{createTime} where id = #{id}")
    public int updateGoods(Goods goods);
}
