package com.book.mall.mall.mapper;

import com.book.mall.mall.entity.Goods;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface GoodsMapper {

    @Select("select * from goods where id = #{id}")
    public Goods getById(Long id);

    
}
