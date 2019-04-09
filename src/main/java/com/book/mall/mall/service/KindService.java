package com.book.mall.mall.service;

import com.book.mall.mall.entity.Kind;
import com.book.mall.mall.mapper.KindMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KindService {
    @Autowired
    private KindMapper kindMapper;

    public List<Kind> findAll(){
        return kindMapper.findAll();
    }
}
