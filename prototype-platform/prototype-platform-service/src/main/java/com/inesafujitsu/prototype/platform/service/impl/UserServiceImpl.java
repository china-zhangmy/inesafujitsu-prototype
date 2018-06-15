package com.inesafujitsu.prototype.platform.service.impl;

import com.inesafujitsu.prototype.platform.model.User;
import com.inesafujitsu.prototype.platform.persist.mapper.UserMapper;
import com.inesafujitsu.prototype.platform.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public List<User> getAll() {
        return userMapper.getAll();
    }

    @Override
    public User getOne(String id) {
        return userMapper.getOne(id);
    }

    @Override
    public void insert(User entity) {

    }

    @Override
    public void update(User entity) {

    }

    @Override
    public void delete(String id) {

    }

}
