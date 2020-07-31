package com.lin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lin.entity.Type;

import java.util.List;

public interface TypeService extends IService<Type> {
    int saveType(Type type);

    Type getType(Long id);

    List<Type>getAllType();

    List<Type> getAllTypeAndBlog();

    Type getTypeByName(String name);

    int updateType(Type type);

    void deleteType(Long id);
}
