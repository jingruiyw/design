package com.book.mall.mall.controller;

import com.book.mall.mall.entity.Kind;
import com.book.mall.mall.service.KindService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/kind")
public class KindController {

    @Autowired
    private KindService kindService;

    @RequestMapping(value = "/list")
    public List<Kind> list(){
        return kindService.findAll();
    }
}
