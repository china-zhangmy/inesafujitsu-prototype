package com.inesafujitsu.prototype.platform.service.trial.impl;

import com.inesafujitsu.prototype.platform.persist.mapper.HelloWorldMapper;
import com.inesafujitsu.prototype.platform.service.trial.HelloWorldService;
import org.springframework.beans.factory.annotation.Autowired;

public class HelloWorldServiceImpl implements HelloWorldService {

    @Autowired
    private HelloWorldMapper helloWorldMapper;

    public String checkDatabase() {
        return helloWorldMapper.checkDatabase().get("database_type");
    }

}
