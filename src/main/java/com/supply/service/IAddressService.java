package com.supply.service;

import com.supply.entity.Address;
import com.baomidou.mybatisplus.extension.service.IService;
import com.supply.domain.DoAddress;
import com.supply.resbean.AddressResBean;
import com.supply.core.KkbResponse;
import org.springframework.util.StringUtils;

import java.time.Instant;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Deniecece
 * @since 2019-04-16
 */
public interface IAddressService extends IService<Address> {

    Address getDetails(String id);

    List<Address> selectByOpenId(String openId);

    KkbResponse addAddress(DoAddress doAddress);

    KkbResponse updateAddress(DoAddress doAddress);

    KkbResponse delAddress(String id);
}
