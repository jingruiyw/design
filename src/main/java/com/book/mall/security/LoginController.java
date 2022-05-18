package com.book.mall.security;

import org.springframework.web.bind.annotation.*;

/**
 * ClassName: LoginController
 * Description:
 * date: 2020/2/22 5:59 下午
 *
 * @author: Jingrui
 * @since JDK 1.8
 */
@RestController
@RequestMapping("/user")
public class LoginController {

    @GetMapping("/login")
    public Object securityLogin() {
        return "登录成功";
    }
}
