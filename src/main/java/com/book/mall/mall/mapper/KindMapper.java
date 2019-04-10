package com.book.mall.mall.mapper;

import com.book.mall.mall.entity.Kind;
import com.book.mall.mall.reqform.KindAddReqForm;
import com.book.mall.mall.resbean.KindAddResBean;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface KindMapper {

    @Select("select * from kind")
    public List<Kind> findAll();

    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into kinds (name, image, createTime) values (#{name}, #{image}, #{createTime)")
    public KindAddResBean add(KindAddReqForm reqForm);
}
