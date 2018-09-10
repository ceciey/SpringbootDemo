package com.invitation.card.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.invitation.card.entity.InvitationCardInfo;
import com.invitation.card.entity.InvitationMusic;
import com.invitation.card.service.InvitationCardInfoService;
import com.invitation.card.service.InvitationMusicService;
import com.invitation.card.utils.ResultBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * 请柬相关的音乐信息
 */
@RestController
@RequestMapping(value = "invitation_music",method = RequestMethod.POST)
public class InvitationMusicController {

    private final InvitationMusicService musicService;

    private final InvitationCardInfoService cardInfoService;

    @Autowired
    public InvitationMusicController(InvitationMusicService musicService, InvitationCardInfoService cardInfoService) {
        this.musicService = musicService;
        this.cardInfoService = cardInfoService;
    }


    @RequestMapping(value = "query")
    public ResultBean<Map<String, Object>> query(@RequestParam String appId){
        ResultBean<Map<String, Object>> resultBean = new ResultBean<>();

        InvitationCardInfo cardInfo = cardInfoService.selectOne(
                new EntityWrapper<InvitationCardInfo>().eq("app_id", appId)
        );
        String cardInfoId = cardInfo.getInvitationCardInfoId();

        InvitationMusic music = musicService.selectOne(
                new EntityWrapper<InvitationMusic>().eq("invitation_card_info_id", cardInfoId)
        );

        Map<String, Object> map = new HashMap<>();
        map.put("musicUrl",music.getMusicUrl());
        map.put("mainInfo",cardInfo);
        resultBean.setData(map);
        return resultBean;
    }
}
