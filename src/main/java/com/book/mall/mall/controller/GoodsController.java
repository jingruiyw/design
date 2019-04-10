package com.book.mall.mall.controller;

import com.book.mall.mall.entity.Goods;
import com.book.mall.mall.reqform.GoodUpdateReqForm;
import com.book.mall.mall.reqform.GoodsAddReqForm;
import com.book.mall.mall.reqform.GoodsFindReqForm;
import com.book.mall.mall.resbean.GoodsAddResBean;
import com.book.mall.mall.resbean.GoodsDelResBean;
import com.book.mall.mall.resbean.GoodsUpdateResBean;
import com.book.mall.mall.service.GoodsService;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/goods")
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

        Integer pageSize = reqForm.getPageSize();
        Integer pageNo = reqForm.getPageNo();

        if("".equals(reqForm.getKind())){
            reqForm.setKind(null);
        }

        if(pageNo == null || pageNo <= 0){
            reqForm.setPageNo(1);
        }

        List<Goods> goods = goodsService.findByConditions(reqForm);
        Long total = goodsService.getTotal(reqForm);

        PageInfo<Goods> page = new PageInfo<>(goods);

        Long totalPage = total%pageSize == 0 ? total/pageSize : total/pageSize + 1;

        if(pageNo != null && pageNo < totalPage) {
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
    public GoodsAddResBean addGoods(@RequestBody GoodsAddReqForm reqForm){
        return goodsService.addGoods(reqForm);
    }

    @RequestMapping(value = "/del", method = RequestMethod.POST)
    public GoodsDelResBean delGoods(@Param("id") Long id){
        return goodsService.delGood(id);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public GoodsUpdateResBean updateGoods(@RequestBody GoodUpdateReqForm reqForm){
        return goodsService.updateGoods(reqForm);
    }
}
