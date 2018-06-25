package com.inesafujitsu.prototype.platform.service.context;

import com.inesafujitsu.prototype.platform.service.HelloWorldService;
import com.inesafujitsu.prototype.platform.service.OrgService;
import com.inesafujitsu.prototype.platform.service.UserGroupService;
import com.inesafujitsu.prototype.platform.service.UserService;
import com.inesafujitsu.prototype.platform.service.impl.HelloWorldServiceImpl;
import com.inesafujitsu.prototype.platform.service.impl.OrgServiceImpl;
import com.inesafujitsu.prototype.platform.service.impl.UserGroupServiceImpl;
import com.inesafujitsu.prototype.platform.service.impl.UserServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({com.inesafujitsu.prototype.platform.persist.context.ApplicationContext.class})
public class ApplicationContext {

    @Bean
    public UserService userService() {
        return new UserServiceImpl();
    }

    @Bean
    public UserGroupService userGroupService() {
        return new UserGroupServiceImpl();
    }

    @Bean
    public OrgService orgService() {
        return new OrgServiceImpl();
    }

    @Bean
    public HelloWorldService helloWorldService() {
        return new HelloWorldServiceImpl();
    }

}
