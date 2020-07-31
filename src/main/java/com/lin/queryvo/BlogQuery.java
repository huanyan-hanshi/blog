package com.lin.queryvo;

import com.lin.entity.Type;
import lombok.Data;

import java.util.Date;

@Data
public class BlogQuery {

    private Long id;
    private String title;
    private Date updateTime;
    private Boolean recommend;
    private Boolean published;
    private Long typeId;
    private Type type;

}
