package com.book.mall.mall.mapper;

import com.book.mall.mall.entity.Goods;
import com.book.mall.mall.reqform.GoodsAddReqForm;
import com.book.mall.mall.reqform.GoodsFindReqForm;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface GoodsMapper {

    @Select("<script>" +
            "select count(*) from goods " +
            "<where>" +
            "<bind name= 'name' value= \" '%' + name + '%'\" />" +
            "<if test='name != null'> AND name like #{name} </if>" +
            "<if test='kind != null'> AND kind = #{kind} </if>" +
            "</where>" +
            "</script>")
    public Long getTotal(GoodsFindReqForm reqForm);

    @Select("<script>" +
            "select * from goods " +
            "<where>" +
            "<bind name= 'name' value= \" '%' + name + '%'\" />" +
            "<if test='name != null'> AND name like #{name} </if>" +
            "<if test='kind != null'> AND kind = #{kind} </if>" +
            "</where>" +
            "limit #{start} offset #{end} " +
            "</script>")
    public List<Goods> findByConditions(GoodsFindReqForm reqForm);

    @Select("select * from goods where id = #{id}")
    public Goods getById(Long id);

    @Delete("delete from goods where id = #{id}")
    public int delById(Long id);

    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into goods(name, price, number, kind, image, status, isbn, remark, create_time) values(#{name}, #{price},#{number},#{kind},#{image},#{status},isbn = #{isbn},#{remark},#{createTime})")
    public int addGoods(GoodsAddReqForm reqForm);

    @Update("update goods set name= #{name}, price= #{price}, number= #{number}, kind= #{kind}, image=#{image}, status=#{status}, isbn = #{isbn}, remark=#{remark}, create_time=#{createTime} where id = #{id}")
    public int updateGoods(Goods goods);

    @Update("update goods set number = #{number} where id = #{id")
    int changeNum(@Param("number") Integer number, @Param("id") Long id);
}
