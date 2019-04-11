package com.book.mall.mall.mapper;

import com.book.mall.mall.entity.Recycle;
import com.book.mall.mall.reqform.RecycleAddReqForm;
import com.book.mall.mall.reqform.RecycleDelReqForm;
import com.book.mall.mall.resbean.RecycleDelResBean;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface RecycleMapper {

    @Select("<script>" +
            "select * from recycle " +
            "limit #{start} offset #{end} " +
            "</script>")
    public List<Recycle> findAll(@Param("start") Integer start, @Param("end") Integer end);

    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into recycle (name, number, kind_id, kind_name, seller, mobile_no, address, status, create_time) values (#{name}, #{number}, #{kindId}, #{kindName}, #{seller}, #{mobileNo}, #{address}, #{status}, #{createTime})")
    public void add(RecycleAddReqForm reqForm);

    @Update("update recycle set status = #{status} where id = #{id}")
    public void updateStatus(@Param("status") String status, @Param("id")Long id);

    @Delete("delete from recycle where id = #{id}")
    public void del(@Param("id") Long id);
}