package com.supply.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.supply.core.KkbResponse;
import com.supply.core.KkbStatus;
import com.supply.domain.DoAddress;
import com.supply.entity.Address;
import com.supply.mapper.AddressMapper;
import com.supply.service.IAddressService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.supply.util.DateUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Deniecece
 * @since 2019-04-16
 */
@Service
public class AddressServiceImpl extends ServiceImpl<AddressMapper, Address> implements IAddressService {

    @Override
    public Address getDetails(String id) {
        return baseMapper.selectById(id);
    }

    @Override
    public List<Address> selectByOpenId(String openId) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("open_id", openId);
        return baseMapper.selectList(queryWrapper);
    }

    @Override
    public KkbResponse addAddress(DoAddress doAddress) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("open_id", doAddress.getOpenId());
        queryWrapper.eq("mobile", doAddress.getMobile());
        queryWrapper.eq("name", doAddress.getName());
        queryWrapper.eq("address", doAddress.getAddress());
        Address address = baseMapper.selectOne(queryWrapper);
        if(address != null) {
            return new KkbResponse(KkbStatus.DATA_EXIST);
        }
        BeanUtils.copyProperties(doAddress, address);
        address.setCreateTime(DateUtil.getCurrentTime());
        int result = baseMapper.insert(address);
        if(result == 1) {
            return new KkbResponse(KkbStatus.SUCCESS);
        }
        return new KkbResponse(KkbStatus.FAILURE);
    }

    @Override
    public KkbResponse updateAddress(DoAddress doAddress) {
        Address address = baseMapper.selectById(doAddress.getId());
        if(address == null) {
            return new KkbResponse(KkbStatus.NO_DATA);
        }
        BeanUtils.copyProperties(doAddress, address);
        int result = baseMapper.updateById(address);
        if(result == 1) {
            return new KkbResponse(KkbStatus.SUCCESS);
        }
        return new KkbResponse(KkbStatus.FAILURE);
    }

    @Override
    public KkbResponse delAddress(String id) {
        int result = baseMapper.deleteById(id);
        if(result == 1) {
            return new KkbResponse(KkbStatus.SUCCESS);
        }
        return new KkbResponse(KkbStatus.FAILURE);
    }
}
