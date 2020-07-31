package com.lin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lin.entity.Message;

import java.util.List;

public interface MessageService extends IService<Message> {

    //查询留言列表
    List<Message> listMessage();

    //保存留言
    int saveMessage(Message message);

    //删除留言
    void deleteMessage(Long id);
}
