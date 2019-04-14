package com.book.mall.mall.controller;

import com.book.mall.mall.entity.Recycle;
import com.book.mall.mall.reqform.RecycleAddReqForm;
import com.book.mall.mall.reqform.RecycleDelReqForm;
import com.book.mall.mall.reqform.RecycleEnsureReqForm;
import com.book.mall.mall.reqform.RecycleFindReqForm;
import com.book.mall.mall.resbean.RecycleAddResBean;
import com.book.mall.mall.resbean.RecycleDelResBean;
import com.book.mall.mall.resbean.RecycleEnsureResBean;
import com.book.mall.mall.resbean.RecycleFindByUserIdResBean;
import com.book.mall.mall.service.RecycleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/recycle")
public class RecycleController {

    @Autowired
    RecycleService recycleService;

    @RequestMapping(value = "/find/by/open/id", method = RequestMethod.GET)
    public RecycleFindByUserIdResBean findByUserId(@Param("openId") Long openId) {
        RecycleFindByUserIdResBean resBean = new RecycleFindByUserIdResBean();

        if(openId == null) {
            resBean.setRecycleList(null);
            return resBean;
        }

        return recycleService.findByUserId(openId);
    }

    @RequestMapping(value = "/del", method = RequestMethod.POST)
    public RecycleDelResBean del(@RequestBody RecycleDelReqForm reqForm) {
        RecycleDelResBean resBean = new RecycleDelResBean();
        if(reqForm.getId() == null) {
            resBean.setCode(1);
            resBean.setMsg("id不能为空");
            return resBean;
        }
        return recycleService.del(reqForm);
    }

    @RequestMapping(value = "/ensure", method = RequestMethod.POST)
    public RecycleEnsureResBean ensure(@RequestBody RecycleEnsureReqForm reqForm){
        RecycleEnsureResBean resBean = new RecycleEnsureResBean();
        if(reqForm.getId() == null) {
            resBean.setCode(1);
            resBean.setMsg("id不能为空");
            return resBean;
        }

        if(reqForm.getName() == null) {
            resBean.setCode(1);
            resBean.setMsg("书籍名称不能为空");
            return resBean;
        }

        if(reqForm.getKindName() == null) {
            resBean.setCode(1);
            resBean.setMsg("种类不能为空");
            return resBean;
        }

        if(reqForm.getNumber() == null) {
            resBean.setCode(1);
            resBean.setMsg("数量不能为空");
            return resBean;
        }

        if(reqForm.getStatus() == null || "已添加".equals(reqForm.getStatus())) {
            resBean.setCode(1);
            resBean.setMsg("当前状态不能入库");
            return resBean;
        }
        return recycleService.ensure(reqForm);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public RecycleAddResBean add(@RequestBody RecycleAddReqForm reqForm) {
        RecycleAddResBean resBean = new RecycleAddResBean();

        if(reqForm.getName() == null) {
            resBean.setCode(1);
            resBean.setMsg("书籍名称不能为空");
            return resBean;
        }

        if(reqForm.getNumber() == null) {
            resBean.setCode(1);
            resBean.setMsg("数量不能为空");
            return resBean;
        }

        if(reqForm.getopenId() == null) {
            resBean.setCode(1);
            resBean.setMsg("关联用户标识不能为空不能为空");
            return resBean;
        }

        if(reqForm.getKindId() == null) {
            resBean.setCode(1);
            resBean.setMsg("种类id不能为空");
            return resBean;
        }

        if(reqForm.getKindName() == null) {
            resBean.setCode(1);
            resBean.setMsg("种类名称不能为空");
            return resBean;
        }

        if(reqForm.getSeller() == null) {
            resBean.setCode(1);
            resBean.setMsg("卖家姓名不能为空");
            return resBean;
        }

        if(reqForm.getMobileNo() == null) {
            resBean.setCode(1);
            resBean.setMsg("卖家联系方式不能为空");
            return resBean;
        }

        if(reqForm.getAddress() == null) {
            resBean.setCode(1);
            resBean.setMsg("卖家地址不能为空");
            return resBean;
        }
        return recycleService.add(reqForm);
    }

    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public List<Recycle> findAll(@RequestBody RecycleFindReqForm reqForm) {
        return recycleService.findAll(reqForm);
    }
}
