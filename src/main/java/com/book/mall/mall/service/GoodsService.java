package com.book.mall.mall.service;

import com.book.mall.mall.entity.Goods;
import com.book.mall.mall.mapper.GoodsMapper;
import com.book.mall.mall.reqform.GoodUpdateReqForm;
import com.book.mall.mall.reqform.GoodsAddReqForm;
import com.book.mall.mall.reqform.GoodsDelReqForm;
import com.book.mall.mall.reqform.GoodsFindReqForm;
import com.book.mall.mall.resbean.GoodsAddResBean;
import com.book.mall.mall.resbean.GoodsDelResBean;
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

        List<Goods> goods = goodsMapper.findByConditions(reqForm);

        for(Goods good : goods) {
            String time = DateUtil.formatDate(Long.parseLong(good.getCreateTime()));
            good.setCreateTime(time);
        }

        return goods;
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
            Goods entity = goods.get(0);
            int newNum = reqForm.getNumber();
            int oldNum = entity.getNumber();
            int total = newNum + oldNum;
            entity.setNumber(total);
            goodsMapper.updateGoods(entity);
            return resBean;
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

    public GoodsDelResBean delGood(GoodsDelReqForm reqForm){
        GoodsDelResBean resBean = new GoodsDelResBean();
        resBean.setCode(0);

        Long id = reqForm.getId();
        if(id == null) {
            resBean.setCode(1);
            resBean.setMsg("id不能为空");
            return resBean;
        }

        goodsMapper.delById(id);
        resBean.setMsg("删除成功");

        return resBean;
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
