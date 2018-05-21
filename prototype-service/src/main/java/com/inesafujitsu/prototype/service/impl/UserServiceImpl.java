package com.inesafujitsu.prototype.service.impl;

import com.inesafujitsu.prototype.model.User;
import com.inesafujitsu.prototype.persist.mapper.UserMapper;
import com.inesafujitsu.prototype.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    public User getUser(Long id) {
        return userMapper.getOne(id);
    }
}
