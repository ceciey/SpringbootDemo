package com.invitation.card.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.invitation.card.entity.InvitationAlbum;
import com.invitation.card.entity.InvitationCardInfo;
import com.invitation.card.service.InvitationAlbumService;
import com.invitation.card.service.InvitationCardInfoService;
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
 * 请柬照片信息
 */
@RestController
@RequestMapping(value = "invitation_album",method = RequestMethod.POST)
public class InvitationAlbumController {

    private final InvitationAlbumService invitationAlbumService;

    private final InvitationCardInfoService invitationCardInfoService;

    /**
     * 注入bean
     * @param invitationAlbumService 照片
     * @param invitationCardInfoService 请柬
     */
    @Autowired
    public InvitationAlbumController(InvitationAlbumService invitationAlbumService, InvitationCardInfoService invitationCardInfoService) {
        this.invitationAlbumService = invitationAlbumService;
        this.invitationCardInfoService = invitationCardInfoService;
    }

    /**
     * 查询请柬照片信息，并携带请柬信息
     * @param appId  微信小程序ID
     * @return 返回值
     */
    @RequestMapping(value = "query")
    public ResultBean<Map<String, Object>> query(@RequestParam String appId){
        //定义返回对象
        ResultBean<Map<String, Object>> resultBean = new ResultBean<>();
        //使用mybatisPlus查询请柬信息
        InvitationCardInfo invitationCardInfo = invitationCardInfoService.selectOne(
                new EntityWrapper<InvitationCardInfo>().eq("app_id", appId)
        );

        //请柬的ID
        String cardInfoId = invitationCardInfo.getInvitationCardInfoId();

        //根据请柬ID查询相关联的照片信息
        List<InvitationAlbum> albumList = invitationAlbumService.selectList(
                new EntityWrapper<InvitationAlbum>().eq("invitation_card_info_id", cardInfoId)
        );
        Map<String, Object> map = new HashMap<>();
        map.put("mainInfo",invitationCardInfo);
        map.put("slideList",albumList);
        resultBean.setData(map);
        return resultBean;
    }
}
