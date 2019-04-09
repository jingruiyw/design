package com.book.mall.mall.mapper;

import com.book.mall.mall.entity.Kind;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface KindMapper {

    @Select("select * from kind")
    public List<Kind> findAll();
}
