package com.book.mall.mall.controller;

import com.book.mall.mall.entity.Goods;
import com.book.mall.mall.reqform.GoodsFindReqForm;
import com.book.mall.mall.service.GoodsService;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
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

    @RequestMapping(value = "/findByConditions", method = RequestMethod.POST)
    public PageInfo<Goods> findByConditions(@RequestBody GoodsFindReqForm reqForm){

        List<Goods> goods = goodsService.findByConditions(reqForm);
        PageInfo<Goods> page = new PageInfo<>(goods);
        page.setTotal(goods.size());
        page.setPageSize(reqForm.getPageSize());
        page.setPageNum(reqForm.getPageNo());
        page.setTotal(goodsService.getTotal(reqForm));
        return page;
    }

    @RequestMapping(value = "/find", method = RequestMethod.POST)
    public PageInfo<Goods> findGoods(@RequestBody GoodsFindReqForm reqForm){

        List<Goods> goods = goodsService.findAll(reqForm.getPageSize(), reqForm.getPageNo());

        PageInfo<Goods> page = new PageInfo<>(goods);
        page.setTotal(goods.size());
        page.setPageSize(reqForm.getPageSize());
        page.setPageNum(reqForm.getPageNo());
        return page;
    }

    @RequestMapping("/get")
    public Goods getGoods(@Param("id") Long id){
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
