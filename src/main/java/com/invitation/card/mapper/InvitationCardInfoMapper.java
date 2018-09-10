package com.invitation.card.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.invitation.card.entity.InvitationCardInfo;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface InvitationCardInfoMapper extends BaseMapper<InvitationCardInfo> {
}
