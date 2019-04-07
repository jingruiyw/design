package com.book.mall.mall.controller;

import com.book.mall.mall.entity.Goods;
import com.book.mall.mall.mapper.GoodsMapper;
import com.book.mall.mall.resbean.SimpleBook;
import com.book.mall.mall.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class GoodsController {

    @Autowired
    GoodsService goodsService;

    @ResponseBody
    @RequestMapping("/hello")
    public String hello() {

        return "hello everyone";
    }

    @GetMapping("/find/{id}")
    public SimpleBook getGoods(@PathVariable("id") Long id){
        return goodsService.getById(id);
    }
}
