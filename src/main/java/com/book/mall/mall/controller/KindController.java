package com.book.mall.mall.controller;

import com.book.mall.mall.entity.Kind;
import com.book.mall.mall.reqform.KindAddReqForm;
import com.book.mall.mall.reqform.KindFindReqForm;
import com.book.mall.mall.resbean.KindAddResBean;
import com.book.mall.mall.resbean.KindDelResBean;
import com.book.mall.mall.service.KindService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/kind")
public class KindController {

    @Autowired
    private KindService kindService;

    @RequestMapping(value = "/del", method = RequestMethod.POST)
    public KindDelResBean del(Long id){
        return kindService.del(id);
    }


    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public KindAddResBean add(@RequestBody KindAddReqForm reqForm) {
        KindAddResBean resBean = new KindAddResBean();
        if(reqForm.getName() == null || "".equals(reqForm.getName())){
            resBean.setCode(1);
            resBean.setMsg("姓名不能为空");
            return resBean;
        }

        if(reqForm.getImage() == null || "".equals(reqForm.getImage())){
            resBean.setCode(1);
            resBean.setMsg("图片不能为空");
            return resBean;
        }
        return kindService.add(reqForm);
    }

    @RequestMapping(value = "/list")
    public PageInfo<Kind> list(@RequestBody KindFindReqForm reqForm){

        Integer pageNo = reqForm.getPageNo();
        Integer pageSize = reqForm.getPageSize();

        if(pageNo == null || pageNo <= 0){
            reqForm.setPageNo(1);
        }

        List<Kind> kinds = kindService.findAll(reqForm);
        Long total = kindService.getTotal(reqForm);
        Long totalPage = total % pageSize == 0 ? total/pageSize : total/pageSize + 1;

        PageInfo<Kind> pageInfo = new PageInfo<>(kinds);

        if(pageNo != null && pageNo < totalPage) {
            pageInfo.setHasNextPage(true);
        }

        pageInfo.setTotal(total);
        pageInfo.setPageNum(reqForm.getPageNo());
        pageInfo.setPageSize(reqForm.getPageSize());

        return pageInfo;
    }
}
