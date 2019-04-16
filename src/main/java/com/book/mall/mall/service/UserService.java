package com.book.mall.mall.service;

import com.book.mall.mall.entity.User;
import com.book.mall.mall.mapper.UserMapper;
import com.book.mall.mall.reqform.UserAddReqForm;
import com.book.mall.mall.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
public class UserService {

    @Autowired
    UserMapper userMapper;

    public User getByOpenId(String openId) {
        return userMapper.selectByOpenId(openId);
    }

    public List<User> getList() {
        return userMapper.selectList();
    }
    public void addUser(UserAddReqForm userAddReqForm) {
        userAddReqForm.setCreateTime(Instant.now().toEpochMilli());
        userMapper.insertUser(userAddReqForm);
    }
}
