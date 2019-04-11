package com.book.mall.mall.mapper;

import com.book.mall.mall.entity.Kind;
import com.book.mall.mall.reqform.KindAddReqForm;
import com.book.mall.mall.reqform.KindFindReqForm;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface KindMapper {

    @Delete("delete from kind where id = #{id}")
    public void del(Long id);

    @Select("<script>" +
            "select count(*) from kind " +
            "</script>")
    public Long getTotal(KindFindReqForm reqForm);

    @Select("<script>" +
            "select * from kind " +
            "limit #{start} offset #{end} " +
            "</script>")
    public List<Kind> findAll(@Param("start") Integer start,@Param("end") Integer end);

    @Select("<script>" +
            "select * from kind " +
            "<where>" +
            "<bind name= 'name' value= \" '%' + name + '%'\" />" +
            "<if test='name != null'> AND name like #{name} </if>" +
            "</where>" +
            "</script>")
    public Kind getByName(@Param("name") String name);

    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into kind (name, image, create_time) values (#{name}, #{image}, #{createTime})")
    public void add(KindAddReqForm reqForm);
}
