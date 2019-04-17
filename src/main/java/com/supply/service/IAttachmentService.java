package com.supply.service;

import com.supply.core.KkbResponse;
import com.supply.domain.DoAttachment;
import com.supply.entity.Attachment;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Deniecece
 * @since 2019-04-16
 */
public interface IAttachmentService extends IService<Attachment> {

    KkbResponse addAttachment(DoAttachment doAttachment);
}
