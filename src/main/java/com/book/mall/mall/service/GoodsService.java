package com.book.mall.mall.service;

import com.book.mall.mall.entity.Goods;
import com.book.mall.mall.mapper.GoodsMapper;
import com.book.mall.mall.reqform.GoodUpdateReqForm;
import com.book.mall.mall.reqform.GoodsAddReqForm;
import com.book.mall.mall.reqform.GoodsFindReqForm;
import com.book.mall.mall.resbean.GoodsAddResBean;
import com.book.mall.mall.resbean.GoodsUpdateResBean;
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

    public GoodsAddResBean addGoods(GoodsAddReqForm reqForm){
        GoodsAddResBean resBean = new GoodsAddResBean();
        resBean.setCode(0);

        String name = reqForm.getName();
        String kind = reqForm.getKind();
        GoodsFindReqForm req = new GoodsFindReqForm();
        req.setName(name);
        req.setKind(kind);

        List<Goods> goods = goodsMapper.findByConditions(req);

        //存在就调用更新方法，把原来的库存更改为传入库存加原来库存
        if(goods.size() != 0){

        }

        //不存在就添加

        //数量不传就默认是1
        if(reqForm.getNumber() == null){
            reqForm.setNumber(1);
        }

        if(reqForm.getRemark() == null) {
            reqForm.setRemark("");
        }

        reqForm.setCreateTime(Instant.now().toEpochMilli());
        goodsMapper.addGoods(reqForm);

        return resBean;
    }

    public void delGood(Long id){
        goodsMapper.delById(id);
    }

    public GoodsUpdateResBean updateGoods(GoodUpdateReqForm reqForm){
        GoodsUpdateResBean resBean = new GoodsUpdateResBean();
        resBean.setCode(0);

        Goods goods = goodsMapper.getById(reqForm.getId());
        if(goods == null) {
            resBean.setCode(1);
            return resBean;
        }

        if(reqForm.getPrice() != null){
            goods.setPrice(reqForm.getPrice());
        }

        if(reqForm.getStatus() != null){
            goods.setStatus(reqForm.getStatus());
        }

        if(reqForm.getImage() != null) {
            goods.setImage(reqForm.getImage());
        }

        if(reqForm.getNumber() != null){
            int num1 = reqForm.getNumber();
            int num2 = goods.getNumber();
            int total = num1 + num2;
            goods.setNumber(total);
        }

        if(reqForm.getRemark() != null){
            goods.setRemark(reqForm.getRemark());
        }

        goodsMapper.updateGoods(goods);

        return resBean;
    }

}
