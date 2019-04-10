package com.book.mall.mall.controller;

import com.book.mall.mall.entity.Kind;
import com.book.mall.mall.reqform.KindFindReqForm;
import com.book.mall.mall.service.KindService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/kind")
public class KindController {

    @Autowired
    private KindService kindService;

    @RequestMapping(value = "/list")
    public PageInfo<Kind> list(@RequestBody KindFindReqForm reqForm){

        Integer pageNo = reqForm.getPageNo();
        Integer pageSize = reqForm.getPageSize();

        if(pageNo == null || pageNo <= 0){
            reqForm.setPageNo(1);
        }

        List<Kind> kinds = kindService.findAll(reqForm);
        Long total = kindService.getTotal(reqForm);
        Long totalPage = total%pageSize == 0 ? total/pageSize : total/pageSize + 1;

        PageInfo<Kind> pageInfo = new PageInfo<>(kinds);

        if(pageNo != null && pageNo < totalPage) {
            pageInfo.setHasNextPage(true);
        }

        pageInfo.setTotal(total);
        pageInfo.setPageNum(pageNo);
        pageInfo.setPageSize(pageSize);

        return pageInfo;
    }
}
