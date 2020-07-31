package com.lin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lin.dao.UserDao;
import com.lin.entity.User;
import com.lin.service.UserService;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserDao, User> implements UserService {
    @Override
    public User checkUser(String username, String password) {
        return baseMapper.selectOne(new QueryWrapper<User>().eq("username",username).eq("password",password));
    }
}
