package com.lin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lin.dao.MessageDao;
import com.lin.entity.Message;
import com.lin.service.MessageService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Service(" messageService")
public class MessageServiceImpl extends ServiceImpl<MessageDao, Message> implements MessageService {
    private List<Message> tempReplys = new ArrayList<>();
    private void combineChildren(List<Message> childMessages, String parentNickname1) {
        //判断是否有一级子回复
        if(childMessages.size() > 0){
            //循环找出子留言的id
            for(Message childMessage : childMessages){
                String parentNickname = childMessage.getNickname();
                childMessage.setParentNickname(parentNickname1);
                tempReplys.add(childMessage);
                Long childId = childMessage.getId();
                //查询二级以及所有子集回复
                recursively(childId, parentNickname);
            }
        }
    }

    private void recursively(Long childId, String parentNickname1) {
        //根据子一级留言的id找到子二级留言
        List<Message> replayMessages = baseMapper.selectList(new QueryWrapper<Message>().eq("parent_message_id",childId).orderByDesc("create_time"));

        if(replayMessages.size() > 0){
            for(Message replayMessage : replayMessages){
                String parentNickname = replayMessage.getNickname();
                replayMessage.setParentNickname(parentNickname1);
                Long replayId = replayMessage.getId();
                tempReplys.add(replayMessage);
                //循环迭代找出子集回复
                recursively(replayId,parentNickname);
            }
        }
    }

    @Override
    public List<Message> listMessage() {
        List<Message> messages = baseMapper.selectList(new QueryWrapper<Message>().eq("parent_message_id",Long.parseLong("-1")).orderByDesc("create_time"));
        for(Message message : messages){
            Long id = message.getId();
            String parentNickname1 = message.getNickname();
            List<Message> childMessages = baseMapper.selectList(new QueryWrapper<Message>().eq("parent_message_id",id).orderByDesc("create_time"));
            //查询出子留言
            combineChildren(childMessages, parentNickname1);
            message.setReplyMessages(tempReplys);
            tempReplys = new ArrayList<>();
        }
        return messages;
    }

    @Override
    public int saveMessage(Message message) {
        message.setCreateTime(new Date());
        return baseMapper.insert(message);
    }

    @Override
    public void deleteMessage(Long id) {
        baseMapper.deleteById(id);
    }
}
