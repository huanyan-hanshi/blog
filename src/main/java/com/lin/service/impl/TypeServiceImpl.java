package com.lin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lin.dao.TypeDao;
import com.lin.entity.Type;
import com.lin.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("typeService")
public class TypeServiceImpl extends ServiceImpl<TypeDao, Type> implements TypeService {
    @Autowired
    TypeDao typeDao;
    @Override
    public int saveType(Type type) {
        return baseMapper.insert(type);
    }

    @Override
    public Type getType(Long id) {
        return baseMapper.selectById(id);
    }

    @Override
    public List<Type> getAllType() {
//        return typeDao.getAllType();
        return baseMapper.selectList(new QueryWrapper<Type>().select("*"));
    }

    @Override
    public List<Type> getAllTypeAndBlog() {
        return typeDao.getAllTypeAndBlog();
    }

    @Override
    public Type getTypeByName(String name) {
        return baseMapper.selectOne(new QueryWrapper<Type>().eq("name",name));
    }

    @Override
    public int updateType(Type type) {
        return baseMapper.updateById(type);
    }

    @Override
    public void deleteType(Long id) {
        baseMapper.deleteById(id);
    }
}
