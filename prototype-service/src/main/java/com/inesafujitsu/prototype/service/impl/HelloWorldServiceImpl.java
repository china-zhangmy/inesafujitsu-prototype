package com.inesafujitsu.prototype.service.impl;

import com.inesafujitsu.prototype.persist.mapper.impl.HelloWorldMapper;
import com.inesafujitsu.prototype.service.HelloWorldService;
import org.springframework.beans.factory.annotation.Autowired;

public class HelloWorldServiceImpl implements HelloWorldService {

    @Autowired
    private HelloWorldMapper helloWorldMapper;

    public String checkDatabase() {
        return helloWorldMapper.checkDatabase().get("database_type");
    }

}
