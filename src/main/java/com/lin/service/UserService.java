package com.lin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lin.entity.User;


public interface UserService extends IService<User> {
    User checkUser(String username, String password);
}
