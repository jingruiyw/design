package com.supply.service;

import com.supply.core.KkbPage;
import com.supply.core.KkbResponse;
import com.supply.domain.DoSupply;
import com.supply.entity.Supply;
import com.supply.entity.Supply;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Deniecece
 * @since 2019-04-16
 */
public interface ISupplyService extends IService<Supply> {

    KkbResponse getDetails(String id);

    KkbResponse selectList(KkbPage kkbPage);

    KkbResponse addSupply(DoSupply doSupply);

    KkbResponse updateSupply(DoSupply doSupply);

    KkbResponse delSupply(String id);

    KkbResponse getNewSupply();
}
