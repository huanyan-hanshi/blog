package com.lin.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@TableName("t_type")
public class Type {
    @TableId
    private Long id;
    private String name;
    @TableField(exist = false)
    private List<Blog>blogs=new ArrayList<>();
}
