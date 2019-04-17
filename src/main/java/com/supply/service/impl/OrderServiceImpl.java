package com.supply.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.supply.core.KkbPage;
import com.supply.core.KkbResponse;
import com.supply.core.KkbStatus;
import com.supply.domain.DoOrder;
import com.supply.entity.Order;
import com.supply.mapper.OrderMapper;
import com.supply.service.IOrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.supply.util.DateUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Deniecece
 * @since 2019-04-16
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements IOrderService {

    @Override
    public KkbResponse getDetails(Integer id) {
        Order supply = baseMapper.selectById(id);
        JSONObject jsonObject = (JSONObject) JSON.toJSON(supply);
        jsonObject.remove("createTime");
        jsonObject.put("createTime", DateUtil.formatDate(supply.getCreateTime().longValue()));
        return new KkbResponse(jsonObject);
    }

    @Override
    public KkbResponse selectByOpenId(String openId, KkbPage kkbPage) {
        List<Map<String, Object>> data = new ArrayList<>();
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.orderByDesc("create_time");
        List<Order> list;
        if(openId == null) {
            list = baseMapper.selectList(queryWrapper);
            list.forEach(order -> {
                JSONObject jsonObject = (JSONObject) JSON.toJSON(order);
                jsonObject.remove("create_time");
                jsonObject.put("createTime", DateUtil.formatDate(order.getCreateTime().longValue()));
                data.add(jsonObject);
            });
            return new KkbResponse(data);
        }
        list = baseMapper.selectPage(kkbPage, queryWrapper).getRecords();
        list.forEach(order -> {
            JSONObject jsonObject = (JSONObject) JSON.toJSON(order);
            jsonObject.remove("create_time");
            jsonObject.put("createTime", DateUtil.formatDate(order.getCreateTime().longValue()));
            data.add(jsonObject);
        });
        kkbPage.setRecords(list);
        return new KkbResponse(kkbPage);
    }

    @Override
    public KkbResponse updateOrder(DoOrder doOrder) {
        Order supply = getById(doOrder.getId());
        if(supply == null) {
            return new KkbResponse(KkbStatus.NO_DATA);
        }
        BeanUtils.copyProperties(doOrder, supply);
        int result = baseMapper.updateById(supply);
        if(result == 1) {
            return new KkbResponse();
        }
        return new KkbResponse(KkbStatus.FAILURE);
    }

    @Override
    public KkbResponse addOrder(DoOrder doOrder) {
        Order supply = new Order();
        BeanUtils.copyProperties(doOrder, supply);
        int result = baseMapper.insert(supply);
        if(result == 1) {
            return new KkbResponse();
        }
        return new KkbResponse(KkbStatus.FAILURE);
    }

    @Override
    public KkbResponse delOrder(String id) {
        Order supply = getById(id);
        if(supply == null) {
            return new KkbResponse(KkbStatus.NO_DATA);
        }
        int result = baseMapper.deleteById(id);
        if(result == 1) {
            return new KkbResponse();
        }
        return new KkbResponse(KkbStatus.FAILURE);
    }
}
