package com.lin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lin.dao.BlogDao;
import com.lin.dao.CommentDao;
import com.lin.entity.Blog;
import com.lin.entity.Comment;
import com.lin.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Service("commentService")
public class CommentServiceImpl extends ServiceImpl<CommentDao, Comment> implements CommentService {
    @Autowired
    BlogDao blogDao;
    private List<Comment> tempReplys = new ArrayList<>();
    private void recursively(Long blogId, Long childId, String parentNickname1){
        List<Comment> replayComments=baseMapper.selectList(new QueryWrapper<Comment>().eq("blog_id",blogId).eq("parent_comment_id",childId).orderByAsc("create_time"));
        if(replayComments.size() > 0){
            for(Comment replayComment : replayComments) {
                String parentNickname = replayComment.getNickname();
                replayComment.setParentNickname(parentNickname1);
                Long replayId = replayComment.getId();
                tempReplys.add(replayComment);
                recursively(blogId,replayId,parentNickname);
            }
        }

    }
    private void combineChildren(Long blogId, List<Comment> childComments, String parentNickname1){
        if (childComments.size()>0){
            for (Comment childComment:childComments){
                String parentNickname=childComment.getParentNickname();
                childComment.setParentNickname(parentNickname);
                tempReplys.add(childComment);
                Long childId=childComment.getId();
                recursively(blogId, childId, parentNickname);
            }
        }
    }
    @Override
    public List<Comment> listCommentByBlogId(Long blogId) {
        List<Comment> comments =baseMapper.selectList(new QueryWrapper<Comment>().eq("blog_id",blogId).eq("parent_comment_id",Long.parseLong("-1")).orderByAsc("create_time"));
        for(Comment comment : comments){
            Long id = comment.getId();
            String parentNickname1 = comment.getNickname();
            List<Comment> childComments = baseMapper.selectList(new QueryWrapper<Comment>().eq("blog_id",blogId).eq("parent_comment_id",id).orderByAsc("create_time"));
            combineChildren(blogId, childComments, parentNickname1);
            comment.setReplyComments(tempReplys);
            tempReplys = new ArrayList<>();
        }
        return comments;
    }

    @Override
    public int saveComment(Comment comment) {
        comment.setCreateTime(new Date());
        int comments=baseMapper.insert(comment);
        blogDao.getCommentCountById(comment.getBlogId());
        return comments;
    }

    @Override
    public void deleteComment(Comment comment, Long id) {
        baseMapper.deleteById(id);
        blogDao.getCommentCountById(comment.getBlogId());
    }
}
