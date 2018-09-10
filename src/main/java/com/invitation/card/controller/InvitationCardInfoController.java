package com.invitation.card.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.invitation.card.entity.InvitationCardInfo;
import com.invitation.card.service.InvitationCardInfoService;
import com.invitation.card.utils.ResultBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Map;


/**
 * 请柬信息控制层
 */
@RestController
@RequestMapping(value = "invitation_card_info",method = RequestMethod.POST)
public class InvitationCardInfoController {
    private final InvitationCardInfoService invitationCardInfoService;

    /**
     * 注入bean
     * @param invitationCardInfoService 请柬
     */
    @Autowired
    public InvitationCardInfoController(InvitationCardInfoService invitationCardInfoService) {
        this.invitationCardInfoService = invitationCardInfoService;
    }

    /**
     *
     * @param appId 微信小程序appId
     * @return 返回值
     */
    @RequestMapping(value = "query")
    public ResultBean<InvitationCardInfo> query(@RequestParam String appId){
        ResultBean<InvitationCardInfo> resultBean = new ResultBean<>();
        InvitationCardInfo result = invitationCardInfoService.selectOne(
                new EntityWrapper<InvitationCardInfo>().eq("app_id",appId)
        );
        resultBean.setData(result);
        resultBean.setCode(200);
        return resultBean;
    }

    /**
     * 保存所有信息
     * @param params 参数
     * @return 返回值
     */
    @RequestMapping(value = "save_all")
    public ResultBean saveAll(@RequestBody Map<String,Object> params){
        ResultBean<Object> resultBean = new ResultBean<>();
        int saveStatus = invitationCardInfoService.insertAll(params);
        resultBean.setData(saveStatus);
        if (saveStatus != -1) {
            resultBean.setCode(200);
        } else {
            resultBean.setCode(400);
        }
        return resultBean;
    }
}
