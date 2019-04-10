package com.book.mall.mall.mapper;

import com.book.mall.mall.entity.Kind;
import com.book.mall.mall.reqform.KindAddReqForm;
import com.book.mall.mall.reqform.KindFindReqForm;
import com.book.mall.mall.resbean.KindAddResBean;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface KindMapper {

    @Select("<script>" +
            "select count(*) from kind " +
            "</script>")
    public Long getTotal(KindFindReqForm reqForm);

    @Select("<script>" +
            "select * from kind " +
            "limit #{start} offset #{end} " +
            "</script>")
    public List<Kind> findAll(@Param("start") Integer start,@Param("end") Integer end);

    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into kinds (name, image, createTime) values (#{name}, #{image}, #{createTime)")
    public KindAddResBean add(KindAddReqForm reqForm);
}
