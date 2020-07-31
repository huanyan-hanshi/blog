package com.lin.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lin.entity.FriendLink;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FriendLinkDao extends BaseMapper<FriendLink> {
    List<FriendLink> listFriendLink();
}
