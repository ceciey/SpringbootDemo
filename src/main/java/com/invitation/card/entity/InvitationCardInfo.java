package com.invitation.card.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

@TableName("invitation_card_info")
public class InvitationCardInfo {

    //请柬信息ID
    @TableId("invitation_card_info_id")
    private  String invitationCardInfoId;

    //男方姓名
    @TableField("man_name")
    private  String he;

    //女方姓名
    @TableField("woman_name")
    private  String she;

    //婚礼举行日期
    @TableField("wedding_date")
    private  String date;

    //农历
    @TableField("lunar_calendar")
    private  String lunar;

    //酒店名称
    @TableField("hotel_name")
    private  String hotel;

    //婚礼地址
    @TableField("address")
    private  String address;

    //分享名称
    @TableField("share_name")
    private  String share;

    //分享内容
    @TableField("thumb_content")
    private  String thumbContent;

    //分享图片URL
    @TableField("thumb_url")
    private  String thumbUrl;

    //男方手机号码
    @TableField("man_tel")
    private  String heTel;

    //女方手机号
    @TableField("woman_tel")
    private  String sheTel;

    //经度
    @TableField("longitude")
    private  String longitude;

    //纬度
    @TableField("latitude")
    private  String latitude;

    @TableField("app_id")
    private  String appId;

    public String getInvitationCardInfoId() {
        return invitationCardInfoId;
    }

    public void setInvitationCardInfoId(String invitationCardInfoId) {
        this.invitationCardInfoId = invitationCardInfoId;
    }

    public String getHe() {
        return he;
    }

    public void setHe(String he) {
        this.he = he;
    }

    public String getShe() {
        return she;
    }

    public void setShe(String she) {
        this.she = she;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLunar() {
        return lunar;
    }

    public void setLunar(String lunar) {
        this.lunar = lunar;
    }

    public String getHotel() {
        return hotel;
    }

    public void setHotel(String hotel) {
        this.hotel = hotel;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getShare() {
        return share;
    }

    public void setShare(String share) {
        this.share = share;
    }

    public String getThumbContent() {
        return thumbContent;
    }

    public void setThumbContent(String thumbContent) {
        this.thumbContent = thumbContent;
    }

    public String getThumbUrl() {
        return thumbUrl;
    }

    public void setThumbUrl(String thumbUrl) {
        this.thumbUrl = thumbUrl;
    }

    public String getHeTel() {
        return heTel;
    }

    public void setHeTel(String heTel) {
        this.heTel = heTel;
    }

    public String getSheTel() {
        return sheTel;
    }

    public void setSheTel(String sheTel) {
        this.sheTel = sheTel;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }
}