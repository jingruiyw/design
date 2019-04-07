package com.book.mall.mall.service;

import com.book.mall.mall.entity.Goods;
import com.book.mall.mall.mapper.GoodsMapper;
import com.book.mall.mall.resbean.SimpleBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GoodsService {

    @Autowired
    GoodsMapper goodsMapper;

    public SimpleBook getById(Long id) {
        Goods goods =  goodsMapper.getById(id);

        SimpleBook sb = new SimpleBook();
        sb.setId(goods.getId());
        sb.setName(goods.getName());

        return sb;
    }


}
