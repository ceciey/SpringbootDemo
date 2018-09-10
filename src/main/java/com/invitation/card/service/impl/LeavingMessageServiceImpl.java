package com.invitation.card.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.invitation.card.entity.LeavingMessage;
import com.invitation.card.mapper.LeavingMessageMapper;
import com.invitation.card.service.LeavingMessageService;
import org.springframework.stereotype.Service;

@Service
public class LeavingMessageServiceImpl extends ServiceImpl<LeavingMessageMapper,LeavingMessage> implements LeavingMessageService {
}
