package com.book.mall.mall.controller;

import com.book.mall.mall.entity.Goods;
import com.book.mall.mall.reqform.GoodsAddReqForm;
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

    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public PageInfo<Goods> findByConditions(@RequestBody GoodsFindReqForm reqForm){

        if(reqForm.getKind().equals("")){
            reqForm.setKind(null);
        }

        List<Goods> goods = goodsService.findByConditions(reqForm);
        PageInfo<Goods> page = new PageInfo<>(goods);
        Long total = goodsService.getTotal(reqForm);
        Integer pageSize = reqForm.getPageSize();
        Integer pageNo = reqForm.getPageNo();
        Long totalPage = total/pageSize + 1;
        if(totalPage > pageNo) {
            page.setHasNextPage(true);
        }
        page.setTotal(goods.size());
        page.setPageSize(reqForm.getPageSize());
        page.setPageNum(reqForm.getPageNo());
        page.setTotal(total);
        return page;
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public Goods getGoods(@Param("id") Long id){
        return goodsService.getById(id);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public void addGoods(@RequestBody GoodsAddReqForm reqForm){
        goodsService.addGoods(reqForm);
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
