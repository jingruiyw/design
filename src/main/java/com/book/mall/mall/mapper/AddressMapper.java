package com.book.mall.mall.mapper;

import com.book.mall.mall.entity.Address;
import com.book.mall.mall.reqform.AddressAddReqForm;
import com.book.mall.mall.reqform.AddressUpdateReqForm;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface AddressMapper {

    @Select("SELECT * FROM address WHERE id = #{id}")
    Address selectById(@Param("id") String id);

    @Select("SELECT * FROM address RIGHT JOIN user ON address.open_id = user.open_id WHERE user.open_id = #{openId} ORDER BY address.create_time DESC")
    List<Address> selectList(@Param("openId") String openId);

    @Select("SELECT count(*) FROM address RIGHT JOIN user ON address.open_id = user.open_id WHERE user.open_id = #{openId}")
    Long getTotal(@Param("openId") String openId);

    @Select("SELECT * FROM address WHERE open_id = #{openId} AND mobile_no = #{mobile} AND name = #{name} AND address = #{address}")
    Address selectOne(@Param("openId") String openId, @Param("mobile") String mobile, @Param("name") String name, @Param("address") String address);

    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("INSERT INTO address (open_id,mobile_no,name,address,create_time) VALUES (#{openId},#{mobileNo},#{name},#{address},#{createTime})")
    int insert(AddressAddReqForm addressAddReqForm);

    @Update("UPDATE address SET mobile_no=#{mobileNo},name=#{name},address=#{address} WHERE id=#{id}")
    int updateAddress(AddressUpdateReqForm addressUpdateReqForm);

    @Delete("DELETE FROM address WHERE id=#{id}")
    int delAddress(@Param("id") String id);

}
