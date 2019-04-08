package com.book.mall.mall.controller;

import com.book.mall.mall.entity.Goods;
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
    public Goods getGoods(@PathVariable("id") Long id){
        return goodsService.getById(id);
    }

    @GetMapping("/add")
    public Goods addGoods(Goods goods){
        goodsService.addGoods(goods);
        return goods;
    }

    @GetMapping("/del")
    public void delGoods(Long id){
        goodsService.delGood(id);
    }

    @GetMapping("/update")
    public Goods updateGoods(Goods goods){
        goodsService.updateGoods(goods);
        return goodsService.getById(goods.getId());
    }

}
