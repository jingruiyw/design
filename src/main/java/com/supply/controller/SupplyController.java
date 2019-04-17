package com.supply.controller;


import com.supply.core.KkbPage;
import com.supply.core.KkbResponse;
import com.supply.domain.DoSupply;
import com.supply.service.ISupplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Deniecece
 * @since 2019-04-16
 */
@RestController
public class SupplyController {

    @Autowired
    ISupplyService iSupplyService;

    /**
     * 详情
     */
    @GetMapping("/supply/{id}")
    public KkbResponse getDetails(@PathVariable String id) {
        return iSupplyService.getDetails(id);
    }

    /**
     * 列表-分页
     */
    @PostMapping("/supply/list")
    public KkbResponse getList(@RequestBody KkbPage kkbPage) {
        return iSupplyService.selectList(kkbPage);
    }
    /**
     * 添加
     */
    @PostMapping("/supply")
    public KkbResponse addSupply(@RequestBody @Valid DoSupply doSupply){
        return iSupplyService.addSupply(doSupply);
    }

    /**
     * 修改
     */
    @PutMapping("/supply")
    public KkbResponse updateSupply(@RequestBody @Valid DoSupply reqForm){
        return iSupplyService.updateSupply(reqForm);
    }

    /**
     * 删除
     */
    @DeleteMapping("/supply/{id}")
    public KkbResponse delSupply(@PathVariable String id){
        return iSupplyService.delSupply(id);
    }

    /**
     * 最新发布
     */
    @GetMapping("/supply/new")
    public KkbResponse getNewSupply() {
        return iSupplyService.getNewSupply();
    }
}

