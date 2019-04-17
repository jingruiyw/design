package com.supply.service.impl;

import com.supply.entity.Order;
import com.supply.mapper.OrderMapper;
import com.supply.service.IOrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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

}
