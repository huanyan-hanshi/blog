package com.lin.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.lin.dao.BlogDao;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@TableName("t_blog")
public class Blog {
    @TableId
    private Long id;
    private String title;
    private String content;
    private String firstPicture;
    private String flag;
    private Integer views;

    @TableField(exist = false)
    private Integer commentCount;

    private boolean appreciation;
    private boolean shareStatement;
    private boolean commentabled;
    private boolean published;
    private boolean recommend;
    private Date createTime;
    private Date updateTime;

    private Long typeId;
    private Long userId;
    private String description;
    @TableField(exist = false)
    private Type type;
    @TableField(exist = false)
    private User user;
    @TableField(exist = false)
    private List<Comment> comments = new ArrayList<>();
}
