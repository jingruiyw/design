package com.book.mall.mall.controller;

import cn.binarywang.wx.miniapp.api.WxMaService;
import cn.binarywang.wx.miniapp.bean.WxMaJscode2SessionResult;
import com.book.mall.mall.reqform.UserAddReqForm;
import com.google.common.collect.Maps;
import me.chanjar.weixin.common.error.WxErrorException;
import org.apache.commons.lang3.StringUtils;
import com.book.mall.mall.entity.User;
import com.book.mall.mall.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
public class UserController {

    private final Logger logger = LoggerFactory.getLogger(getClass());
    private static Map<String, WxMaService> maServices = Maps.newHashMap();

    @Autowired
    UserService userService;

    /**
     * 列表
     */
    @GetMapping("/user/list")
    public List<User> getList() {
        return userService.getList();
    }

    /**
     * 获取openId
     */
    @GetMapping("/user/openId")
    public String getOpenId(@RequestParam("code") String code) {
        if (StringUtils.isBlank(code)) {
            return "empty jscode";
        }
        final WxMaService wxService = maServices.get("wxb39a7d55e5d5b0f1");
        String openId = null;
        try {
            WxMaJscode2SessionResult session = wxService.getUserService().getSessionInfo(code);
            openId = session.getOpenid();
        } catch (WxErrorException e) {
            logger.error(e.getMessage(), e);
        }
        return openId;
    }

    /**
     * 新增
     */
    @RequestMapping(value = "/user/add", method = RequestMethod.POST)
//    @PostMapping("/user/add")
    public void addUser(@RequestBody @Valid UserAddReqForm userAddReqForm) {
        userService.addUser(userAddReqForm);
    }

}
