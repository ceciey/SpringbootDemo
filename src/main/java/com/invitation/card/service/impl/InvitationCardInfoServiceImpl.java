package com.invitation.card.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.invitation.card.entity.InvitationAlbum;
import com.invitation.card.entity.InvitationCardInfo;
import com.invitation.card.entity.InvitationMusic;
import com.invitation.card.mapper.InvitationAlbumMapper;
import com.invitation.card.mapper.InvitationCardInfoMapper;
import com.invitation.card.mapper.InvitationMusicMapper;
import com.invitation.card.service.InvitationCardInfoService;
import com.invitation.card.utils.BeanUtils;
import com.invitation.card.utils.IdUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Map;

@Slf4j
@Service
public class InvitationCardInfoServiceImpl extends ServiceImpl<InvitationCardInfoMapper, InvitationCardInfo>
                                            implements InvitationCardInfoService {

    private final InvitationAlbumMapper invitationAlbumMapper;

    private final InvitationMusicMapper invitationMusicMapper;

    //注入图片、音乐的mapper
    @Autowired
    public InvitationCardInfoServiceImpl(InvitationAlbumMapper invitationAlbumMapper, InvitationMusicMapper invitationMusicMapper) {
        this.invitationAlbumMapper = invitationAlbumMapper;
        this.invitationMusicMapper = invitationMusicMapper;
    }


    /**
     * 保存请柬信息
     * 加入事物控制
     * @param params 入参
     * @return 保存状态
     */
    @Transactional
    @Override
    public int insertAll(Map<String, Object> params) {
        int saveStatus = -1;
        try {
            //生成一个请柬的ID
            String cardId = IdUtils.uuid();
            //json转bean
            InvitationCardInfo card = BeanUtils.mapToObject(params, InvitationCardInfo.class);
            card.setInvitationCardInfoId(cardId);
            log.debug("请柬基本信息：{}",card);
            saveStatus = this.baseMapper.insert(card);
            log.info("新增请柬基本信息成功！");

            //请柬相关的音乐新增
            InvitationMusic music = BeanUtils.mapToObject(params, InvitationMusic.class);
            music.setMusicId(IdUtils.uuid());
            music.setInvitationCardInfoId(cardId);
            log.debug("请柬音乐信息：{}",music);
            saveStatus = invitationMusicMapper.insert(music);
            log.info("新增请柬音乐信息成功！");

            //请柬照片
            InvitationAlbum album = BeanUtils.mapToObject(params, InvitationAlbum.class);
            album.setAlbum_id(IdUtils.uuid());
            album.setInvitationCardInfoId(cardId);
            log.debug("请柬照片信息：{}",album);
            saveStatus = invitationAlbumMapper.insert(album);
            log.info("新增请柬照片信息成功！");
        } catch (Exception e) {
           log.error("新增失败，数据回滚：{}",e);
        }
        return saveStatus;
    }
}
