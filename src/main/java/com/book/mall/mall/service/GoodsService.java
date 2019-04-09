package com.book.mall.mall.service;

import com.book.mall.mall.entity.Goods;
import com.book.mall.mall.mapper.GoodsMapper;
import com.book.mall.mall.reqform.GoodsAddReqForm;
import com.book.mall.mall.reqform.GoodsFindReqForm;
import com.book.mall.mall.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
public class GoodsService {

    @Autowired
    GoodsMapper goodsMapper;

    public Long getTotal(GoodsFindReqForm reqForm){
        return goodsMapper.getTotal(reqForm);
    }

    public List<Goods> findByConditions(GoodsFindReqForm reqForm){
        Integer start = reqForm.getPageSize();
        Integer end = (reqForm.getPageNo()-1)*reqForm.getPageSize();

        reqForm.setStart(start);
        reqForm.setEnd(end);


        return goodsMapper.findByConditions(reqForm);
    }

    public Goods getById(Long id) {
        Goods goods =  goodsMapper.getById(id);

        String createTime = goods.getCreateTime();
        Long time = Long.parseLong(createTime);
        goods.setCreateTime(DateUtil.formatDate(time));

        return goods;
    }

    public void addGoods(GoodsAddReqForm reqForm){
        if(reqForm.getNumber() == null){
            reqForm.setNumber(0);
        }

        if(reqForm.getStock() == null) {
            reqForm.setStock(0);
        }

        if(reqForm.getRemark() == null) {
            reqForm.setRemark("");
        }

        reqForm.setCreateTime(Instant.now().toEpochMilli());
        goodsMapper.addGoods(reqForm);
    }

    public void delGood(Long id){
        goodsMapper.delById(id);
    }

    public void updateGoods(Goods goods){
        goodsMapper.updateGoods(goods);
    }
}
