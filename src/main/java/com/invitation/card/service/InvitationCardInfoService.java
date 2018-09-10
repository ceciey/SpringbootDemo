package com.invitation.card.service;

import com.baomidou.mybatisplus.service.IService;
import com.invitation.card.entity.InvitationCardInfo;

import java.util.Map;

public interface InvitationCardInfoService extends IService<InvitationCardInfo> {

    int insertAll(Map<String, Object> params);
}
