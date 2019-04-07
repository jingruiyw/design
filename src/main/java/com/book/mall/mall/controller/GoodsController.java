package com.book.mall.mall.controller;

import com.book.mall.mall.entity.Goods;
import com.book.mall.mall.mapper.GoodsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class GoodsController {

    @Autowired
    GoodsMapper goodsMapper;

    @ResponseBody
    @RequestMapping("/hello")
    public String hello() {

        return "hello everyone";
    }

    @GetMapping("/find/{id}")
    public Goods getGoods(@PathVariable("id") Long id){
        return goodsMapper.getById(id);
    }
}
