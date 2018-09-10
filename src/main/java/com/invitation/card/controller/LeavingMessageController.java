package com.invitation.card.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.invitation.card.entity.InvitationCardInfo;
import com.invitation.card.entity.LeavingMessage;
import com.invitation.card.service.InvitationCardInfoService;
import com.invitation.card.service.LeavingMessageService;
import com.invitation.card.utils.ResultBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 留言
 */
@RestController
@RequestMapping(value = "leaving_message",method = RequestMethod.POST)
public class LeavingMessageController {

    private final InvitationCardInfoService invitationCardInfoService;

    private final LeavingMessageService leavingMessageService;

    @Autowired
    public LeavingMessageController(InvitationCardInfoService invitationCardInfoService, LeavingMessageService leavingMessageService) {
        this.invitationCardInfoService = invitationCardInfoService;
        this.leavingMessageService = leavingMessageService;
    }

    @RequestMapping(value = "query")
    public ResultBean<Map<Object, Object>> query(@RequestParam String appId){
        ResultBean<Map<Object, Object>> resultBean = new ResultBean<>();
        InvitationCardInfo cardInfo = invitationCardInfoService.selectOne(
                new EntityWrapper<InvitationCardInfo>().eq("app_id", appId)
        );
        String cardInfoId = cardInfo.getInvitationCardInfoId();

        List<LeavingMessage> leavingMessage = leavingMessageService.selectList(
                new EntityWrapper<LeavingMessage>().eq("invitation_card_info_id", cardInfoId)
        );
        Map<Object, Object> map = new HashMap<>();
        map.put("mainInfo",cardInfo);
        map.put("chatList",leavingMessage);
        resultBean.setData(map);
        return resultBean;
    }
}
