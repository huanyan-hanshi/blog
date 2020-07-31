package com.lin.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Data
@TableName("t_comment")
public class Comment {
    @TableId
    private Long id;
    private String nickname;
    private String email;
    private String content;

    //头像
    private String avatar;
    private Date createTime;

    private Long blogId;
    private Long parentCommentId;
    @TableField(exist = false)
    private String parentNickname;

    //回复评论
    @TableField(exist = false)
    private List<Comment> replyComments = new ArrayList<>();
    @TableField(exist = false)
    private Comment parentComment;
    private boolean adminComment;

//    private DetailedBlog blog;
}
