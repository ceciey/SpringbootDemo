package com.invitation.card.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

/**
 * 音乐
 */
@TableName("invitation_music")
public class InvitationMusic extends BaseEntity{

    /**
     * 主键ID
     */
    @TableId("music_id")
    private String musicId;

    /**
     * 请柬ID
     */
    @TableField("invitation_card_info_id")
    private String invitationCardInfoId;

    /**
     * 音乐URL
     */
    @TableField("music_url")
    private String musicUrl;

    public String getMusicId() {
        return musicId;
    }

    public void setMusicId(String musicId) {
        this.musicId = musicId;
    }

    public String getInvitationCardInfoId() {
        return invitationCardInfoId;
    }

    public void setInvitationCardInfoId(String invitationCardInfoId) {
        this.invitationCardInfoId = invitationCardInfoId;
    }

    public String getMusicUrl() {
        return musicUrl;
    }

    public void setMusicUrl(String musicUrl) {
        this.musicUrl = musicUrl;
    }
}
