package com.book.mall.mall.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {

    @ResponseBody
    @RequestMapping("/hello")
    public String hello() {

        return "hello";
    }
}
