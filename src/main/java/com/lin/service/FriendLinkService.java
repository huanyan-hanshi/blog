package com.lin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lin.entity.FriendLink;

import java.util.List;

public interface FriendLinkService extends IService<FriendLink> {
    //查询所有友链
    List<FriendLink> listFriendLink();

    //友链新增
    int saveFriendLink(FriendLink friendLink);

    //根据id查询友链
    FriendLink getFriendLink(Long id);

    //根据网址查询友链
    FriendLink getFriendLinkByBlogaddress(String blogaddress);

    //编辑修改友链
    int updateFriendLink(FriendLink friendLink);

    //删除友链
    void deleteFriendLink(Long id);
}
