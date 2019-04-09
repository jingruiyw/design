package com.book.mall.mall.controller;

import com.book.mall.mall.entity.Goods;
import com.book.mall.mall.reqform.GoodsFindReqForm;
import com.book.mall.mall.service.GoodsService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class GoodsController {

    @Autowired
    GoodsService goodsService;

    @ResponseBody
    @RequestMapping("/hello")
    public String hello() {

        return "hello everyone";
    }

    @RequestMapping(value = "/findByName", method = RequestMethod.POST)
    public List<Goods> findByName(@RequestBody GoodsFindReqForm reqForm){
        return goodsService.findByName(reqForm);
    }

    @RequestMapping(value = "/find", method = RequestMethod.POST)
    public PageInfo<Goods> findGoods(@RequestBody GoodsFindReqForm reqForm){

//        PageHelper.startPage(reqForm.getPageNum(), reqForm.getPageSize());
        List<Goods> goods = goodsService.findAll(reqForm.getPageSize(), reqForm.getPageNum());

        PageInfo<Goods> page = new PageInfo(goods);
        return page;
    }

    @GetMapping("/get")
    public Goods getGoods(Long id){
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
