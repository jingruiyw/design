package com.supply.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.supply.core.KkbPage;
import com.supply.core.KkbResponse;
import com.supply.domain.DoOrder;
import com.supply.entity.TOrder;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Deniecece
 * @since 2019-04-16
 */
public interface IOrderService extends IService<TOrder> {

    KkbResponse getDetails(Integer id);

    KkbResponse selectByOpenId(String openId, KkbPage kkbPage);

    KkbResponse updateOrder(DoOrder doOrder);

    KkbResponse addOrder(DoOrder doOrder);

    KkbResponse delOrder(Integer id);

}
