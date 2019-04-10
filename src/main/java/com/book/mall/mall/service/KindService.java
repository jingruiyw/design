package com.book.mall.mall.service;

import com.book.mall.mall.entity.Kind;
import com.book.mall.mall.mapper.KindMapper;
import com.book.mall.mall.reqform.KindFindReqForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KindService {
    @Autowired
    private KindMapper kindMapper;

    public List<Kind> findAll(KindFindReqForm reqForm){

        Integer start = reqForm.getPageSize();
        Integer end = (reqForm.getPageNo()-1)*reqForm.getPageSize();

        return kindMapper.findAll(start, end);
    }

    public Long getTotal(KindFindReqForm reqForm){

        return kindMapper.getTotal(reqForm);
    }
}
