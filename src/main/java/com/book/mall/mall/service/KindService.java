package com.book.mall.mall.service;

import com.book.mall.mall.entity.Kind;
import com.book.mall.mall.mapper.KindMapper;
import com.book.mall.mall.reqform.KindAddReqForm;
import com.book.mall.mall.reqform.KindFindReqForm;
import com.book.mall.mall.resbean.KindAddResBean;
import com.book.mall.mall.resbean.KindDelResBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
public class KindService {
    @Autowired
    private KindMapper kindMapper;

    public KindDelResBean del(Long id) {
        KindDelResBean resBean = new KindDelResBean();
        resBean.setCode(0);

        if(id == null) {
            resBean.setCode(1);
            resBean.setMsg("删除失败");
            return resBean;
        }

        kindMapper.del(id);
        resBean.setMsg("删除成功");
        return resBean;
    }

    public KindAddResBean add(KindAddReqForm reqForm) {
        reqForm.setCreateTime(Instant.now().toEpochMilli());
        KindAddResBean resBean = new KindAddResBean();
        resBean.setCode(0);

        Kind kind = kindMapper.getByName(reqForm.getName());
        if(kind != null) {
            resBean.setCode(1);
            resBean.setMsg("该种类已经存在");
            return resBean;
        }
        kindMapper.add(reqForm);
        resBean.setMsg("添加成功");
        return resBean;
    }

    public List<Kind> findAll(KindFindReqForm reqForm){

        Integer start = reqForm.getPageSize();
        Integer end = (reqForm.getPageNo()-1)*reqForm.getPageSize();

        return kindMapper.findAll(start, end);
    }

    public Long getTotal(KindFindReqForm reqForm){

        return kindMapper.getTotal(reqForm);
    }
}
