package com.invitation.card.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

/**
 * 照片
 */
@TableName("invitation_album")
public class InvitationAlbum extends BaseEntity {

    /**
     * 照片主键ID
     */
    @TableId("album_id")
    private String album_id;

    /**
     * 请柬ID
     */
    @TableField("invitation_card_info_id")
    private String invitationCardInfoId;

    /**
     * 照片URL
     */
    @TableField("album_url")
    private String image;

    public String getAlbum_id() {
        return album_id;
    }

    public void setAlbum_id(String album_id) {
        this.album_id = album_id;
    }

    public String getInvitationCardinfoId() {
        return invitationCardInfoId;
    }

    public void setInvitationCardInfoId(String invitationCardInfoId) {
        this.invitationCardInfoId = invitationCardInfoId;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
