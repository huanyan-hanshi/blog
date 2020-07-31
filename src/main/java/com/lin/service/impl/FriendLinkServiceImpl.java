package com.lin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lin.dao.FriendLinkDao;
import com.lin.entity.FriendLink;
import com.lin.service.FriendLinkService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("friendLinkService")
public class FriendLinkServiceImpl extends ServiceImpl<FriendLinkDao, FriendLink> implements FriendLinkService {

    @Override
    public List<FriendLink> listFriendLink() {
        return baseMapper.selectList(new QueryWrapper<FriendLink>().select("*").orderByDesc());
    }

    @Override
    public int saveFriendLink(FriendLink friendLink) {
        return baseMapper.insert(friendLink);
    }

    @Override
    public FriendLink getFriendLink(Long id) {
        return baseMapper.selectById(id);
    }

    @Override
    public FriendLink getFriendLinkByBlogaddress(String blogaddress) {
        return baseMapper.selectOne(new QueryWrapper<FriendLink>().eq("blogaddress",blogaddress));
    }

    @Override
    public int updateFriendLink(FriendLink friendLink) {
        return baseMapper.updateById(friendLink);
    }

    @Override
    public void deleteFriendLink(Long id) {
        baseMapper.deleteById(id);
    }
}
