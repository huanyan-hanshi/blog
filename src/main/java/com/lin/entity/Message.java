package com.lin.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@TableName("t_message")
public class Message {
    @TableId
    private Long id;
    private String nickname;
    private String email;
    private String content;
    private String avatar;
    private Date createTime;
    private Long parentMessageId;
    private boolean adminMessage;

    //回复评论
    @TableField(exist = false)
    private List<Message> replyMessages = new ArrayList<>();
    @TableField(exist = false)
    private Message parentMessage;
    @TableField(exist = false)
    private String parentNickname;
}
