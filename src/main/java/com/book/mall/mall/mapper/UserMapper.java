package com.book.mall.mall.mapper;

import com.book.mall.mall.entity.User;
import com.book.mall.mall.reqform.UserAddReqForm;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserMapper {

    @Select("SELECT * FROM user WHERE open_id = #{openId}")
    User selectByOpenId(@Param("openId") String openId);

    @Select("SELECT * FROM user")
    List<User> selectList();

    @Insert("INSERT INTO user (name,image,open_id,create_time) VALUES (#{name},#{image},#{openId},#{createTime})")
    int insertUser(UserAddReqForm userAddReqForm);

}
