package com.invitation.card.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

@TableName("leaving_message")
public class LeavingMessage extends BaseEntity{

    /**
     * 留言ID
     */
    @TableId("leaving_message_id")
    private String leavingMessageId;

    @TableField("invitation_card_info_id")
    private String invitationCardInfoId;
    /**
     * 留言人昵称
     */
    @TableField("leaving_name")
    private String nickname;

    /**
     * 留言人内容
     */
    @TableField("leaving_content")
    private String words;

    /**
     * 头像
     */
    @TableField("leaving_url")
    private String face;

    public String getLeavingMessageId() {
        return leavingMessageId;
    }

    public void setLeavingMessageId(String leavingMessageId) {
        this.leavingMessageId = leavingMessageId;
    }

    public String getInvitationCardInfoId() {
        return invitationCardInfoId;
    }

    public void setInvitationCardInfoId(String invitationCardInfoId) {
        this.invitationCardInfoId = invitationCardInfoId;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getWords() {
        return words;
    }

    public void setWords(String words) {
        this.words = words;
    }

    public String getFace() {
        return face;
    }

    public void setFace(String face) {
        this.face = face;
    }

    @Override
    public String toString() {
        return "LeavingMessage{" +
                "leavingMessageId='" + leavingMessageId + '\'' +
                ", nickname='" + nickname + '\'' +
                ", words='" + words + '\'' +
                ", face='" + face + '\'' +
                '}';
    }
}
