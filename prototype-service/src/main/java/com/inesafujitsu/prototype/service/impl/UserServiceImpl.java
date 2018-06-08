package com.inesafujitsu.prototype.service.impl;

import com.inesafujitsu.prototype.model.platform.User;
import com.inesafujitsu.prototype.persist.mapper.UserMapper;
import com.inesafujitsu.prototype.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public User getOne(String id) {
        return userMapper.getOne(id);
    }
}
