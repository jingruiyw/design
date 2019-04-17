package com.supply.service.impl;

import com.supply.core.KkbResponse;
import com.supply.core.KkbStatus;
import com.supply.domain.DoAttachment;
import com.supply.entity.Attachment;
import com.supply.entity.Supply;
import com.supply.mapper.AttachmentMapper;
import com.supply.service.IAttachmentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.supply.service.ISupplyService;
import com.supply.util.DateUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
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
public class AttachmentServiceImpl extends ServiceImpl<AttachmentMapper, Attachment> implements IAttachmentService {

    @Autowired
    ISupplyService iSupplyService;

    @Override
    public KkbResponse addAttachment(DoAttachment doAttachment) {
        Supply supply = iSupplyService.getById(doAttachment.getSupplyId());
        if(supply == null) {
            return new KkbResponse(KkbStatus.NO_DATA.getCode(), "商品不存在");
        }
        Attachment attachment = new Attachment();
        BeanUtils.copyProperties(doAttachment, attachment);
        attachment.setCreateTime(DateUtil.getCurrentTime());
        int result = baseMapper.insert(attachment);
        if(result == 1) {
            return new KkbResponse();
        }
        return new KkbResponse(KkbStatus.FAILURE);
    }
}
