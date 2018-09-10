package com.invitation.card.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

/**
 * 祝福
 */
@TableName("blessing_info")
public class BlessingInfo extends BaseEntity{

    /**
     * 祝福人ID
     */
    @TableId("blessing_id")
    private String blessingId;

    /**
     * 请柬ID
     */
    @TableField("invitation_card_info_id")
    private String invitationCardInfoId;

    /**
     * 祝福人昵称
     */
    @TableField("blessing_name")
    private String blessing_name;

    /**
     * 祝福人头像
     */
    @TableField("blessing_head_portrait")
    private String face;


    public String getBlessingId() {
        return blessingId;
    }

    public void setBlessingId(String blessingId) {
        this.blessingId = blessingId;
    }

    public String getInvitationCardInfoId() {
        return invitationCardInfoId;
    }

    public void setInvitationCardInfoId(String invitationCardInfoId) {
        this.invitationCardInfoId = invitationCardInfoId;
    }

    public String getBlessing_name() {
        return blessing_name;
    }

    public void setBlessing_name(String blessing_name) {
        this.blessing_name = blessing_name;
    }

    public String getFace() {
        return face;
    }

    public void setFace(String face) {
        this.face = face;
    }

}
