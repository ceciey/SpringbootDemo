package com.invitation.card.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.invitation.card.entity.BlessingInfo;
import com.invitation.card.entity.InvitationCardInfo;
import com.invitation.card.service.BlessingInfoService;
import com.invitation.card.service.InvitationCardInfoService;
import com.invitation.card.utils.ResultBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 祝福
 */
@RestController
@RequestMapping(value = "blessing_info",method = RequestMethod.POST)
public class BlessingInfoController {

    private final BlessingInfoService blessingInfoService;

    private final InvitationCardInfoService invitationCardInfoService;

    @Autowired
    public BlessingInfoController(InvitationCardInfoService invitationCardInfoService, BlessingInfoService blessingInfoService) {
        this.invitationCardInfoService = invitationCardInfoService;
        this.blessingInfoService = blessingInfoService;
    }

    @RequestMapping(value = "query")
    public ResultBean<Map<String, Object>> query(@RequestParam String appId){
        ResultBean<Map<String, Object>> resultBean = new ResultBean<>();
        Map<String, Object> map = new HashMap<>();
        InvitationCardInfo invitationCardInfo = invitationCardInfoService.selectOne(
                new EntityWrapper<InvitationCardInfo>().eq("app_id", appId)
        );
        String invitationCardInfoId = invitationCardInfo.getInvitationCardInfoId();
        List<BlessingInfo> blessingInfo = blessingInfoService.selectList(
                new EntityWrapper<BlessingInfo>().eq("invitation_card_info_id", invitationCardInfoId)
        );
        map.put("mainInfo",invitationCardInfo);
        map.put("zanLog",blessingInfo);
        map.put("zanNum",blessingInfo.size());
        resultBean.setData(map);
        return resultBean;
    }
}
