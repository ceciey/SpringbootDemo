package com.invitation.card.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.invitation.card.entity.BlessingInfo;
import com.invitation.card.mapper.BlessingInfoMapper;
import com.invitation.card.service.BlessingInfoService;
import org.springframework.stereotype.Service;

@Service
public class BlessingInfoServiceImpl extends ServiceImpl<BlessingInfoMapper,BlessingInfo> implements BlessingInfoService {
}
