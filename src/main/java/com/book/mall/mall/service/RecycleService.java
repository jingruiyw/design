package com.book.mall.mall.service;

import com.book.mall.mall.entity.Goods;
import com.book.mall.mall.entity.Recycle;
import com.book.mall.mall.mapper.GoodsMapper;
import com.book.mall.mall.mapper.RecycleMapper;
import com.book.mall.mall.reqform.*;
import com.book.mall.mall.resbean.RecycleAddResBean;
import com.book.mall.mall.resbean.RecycleDelResBean;
import com.book.mall.mall.resbean.RecycleEnsureResBean;
import com.book.mall.mall.resbean.RecycleFindByUserIdResBean;
import com.book.mall.mall.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
public class RecycleService {

    @Autowired
    private RecycleMapper recycleMapper;
    @Autowired
    private GoodsMapper goodsMapper;

    public RecycleFindByUserIdResBean findByUserId(Long openId) {
        RecycleFindByUserIdResBean resBean = new RecycleFindByUserIdResBean();
        List<Recycle> recycles = recycleMapper.findByUserId(openId);

        for(Recycle recycle : recycles) {
            recycle.setCreateTime(DateUtil.formatDate(Long.parseLong(recycle.getCreateTime())));
        }
        resBean.setRecycleList(recycles);
        return resBean;
    }

    public RecycleDelResBean del(RecycleDelReqForm reqForm) {
        RecycleDelResBean resBean = new RecycleDelResBean();
        resBean.setCode(0);
        resBean.setMsg("删除成功");

        recycleMapper.del(reqForm.getId());
        return resBean;
    }

    public RecycleEnsureResBean ensure(RecycleEnsureReqForm reqForm) {
        RecycleEnsureResBean resBean = new RecycleEnsureResBean();
        resBean.setCode(0);
        resBean.setMsg("入库成功");

        String name = reqForm.getName();
        String kind = reqForm.getKindName();
        GoodsFindReqForm gfr = new GoodsFindReqForm();
        gfr.setName(name);
        gfr.setKind(kind);

        List<Goods> goods = goodsMapper.findByConditions(gfr);

        if(goods.size() == 0) {
            resBean.setCode(1);
            resBean.setMsg("该书籍尚未在商品库添加, 请添加后再确认入库");
            return resBean;
        }

        //修改库存
        Goods entity = goods.get(0);
        Integer oldNum = entity.getNumber();
        Integer newNum = reqForm.getNumber();
        Integer total = oldNum + newNum;
        entity.setNumber(total);
        goodsMapper.updateGoods(entity);

        //更改自己的订单状态
        recycleMapper.updateStatus("已添加", reqForm.getId());

        return resBean;
    }

    public RecycleAddResBean add(RecycleAddReqForm reqForm) {
        RecycleAddResBean resBean = new RecycleAddResBean();
        resBean.setCode(0);
        resBean.setMsg("添加成功");

        reqForm.setStatus("未添加");
        reqForm.setCreateTime(Instant.now().toEpochMilli());
        recycleMapper.add(reqForm);

        return resBean;
    }

    public List<Recycle> findAll(RecycleFindReqForm reqForm) {

        List<Recycle> recycles = recycleMapper.findAll(reqForm.getStart(), reqForm.getEnd());
        for(Recycle recycle : recycles) {
            recycle.setCreateTime(DateUtil.formatDate(Long.parseLong(recycle.getCreateTime())));
        }
        return recycles;
    }
}
