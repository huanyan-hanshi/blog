package com.lin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lin.entity.Comment;

import java.util.List;

public interface CommentService extends IService<Comment> {
    List<Comment> listCommentByBlogId(Long blogId);

    int saveComment(Comment comment);

//    查询子评论
//    List<Comment> getChildComment(Long blogId,Long id);

    //删除评论
    void deleteComment(Comment comment,Long id);
}
