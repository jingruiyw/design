package com.book.mall.mall.service;

import com.book.mall.mall.entity.User;
import com.book.mall.mall.mapper.UserMapper;
import com.book.mall.mall.reqform.UserAddReqForm;
import com.book.mall.mall.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.time.Instant;
import java.util.List;

@Service
public class UserService {

    @Autowired
    UserMapper userMapper;

    public User getByOpenId(String openId) {
        User user = userMapper.selectByOpenId(openId);
        if(user != null) {
            user.setCreateTime(DateUtil.formatDate(Long.parseLong(user.getCreateTime())));
        }
        return user;
    }

    public List<User> getList() {
        List<User> users = userMapper.selectList();
        if(!CollectionUtils.isEmpty(users)) {
            users.forEach(user -> user.setCreateTime(DateUtil.formatDate(Long.parseLong(user.getCreateTime()))));
        }
        return users;
    }
    public void addUser(UserAddReqForm userAddReqForm) {
        userAddReqForm.setCreateTime(Instant.now().toEpochMilli());
        userAddReqForm.setOpenId(String.valueOf(Instant.now().toEpochMilli()));
        userMapper.insertUser(userAddReqForm);
    }
}
