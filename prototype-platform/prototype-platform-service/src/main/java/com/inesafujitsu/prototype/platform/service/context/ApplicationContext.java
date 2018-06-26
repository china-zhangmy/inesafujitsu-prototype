package com.inesafujitsu.prototype.platform.service.context;

import com.inesafujitsu.prototype.platform.service.ctrl.PrivilegeService;
import com.inesafujitsu.prototype.platform.service.ctrl.impl.PrivilegeServiceImpl;
import com.inesafujitsu.prototype.platform.service.orgchart.GroupService;
import com.inesafujitsu.prototype.platform.service.orgchart.OrgService;
import com.inesafujitsu.prototype.platform.service.orgchart.UserService;
import com.inesafujitsu.prototype.platform.service.orgchart.impl.GroupServiceImpl;
import com.inesafujitsu.prototype.platform.service.orgchart.impl.OrgServiceImpl;
import com.inesafujitsu.prototype.platform.service.orgchart.impl.UserServiceImpl;
import com.inesafujitsu.prototype.platform.service.trial.HelloWorldService;
import com.inesafujitsu.prototype.platform.service.trial.impl.HelloWorldServiceImpl;
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
    public GroupService groupService() {
        return new GroupServiceImpl();
    }

    @Bean
    public OrgService orgService() {
        return new OrgServiceImpl();
    }

    @Bean
    public PrivilegeService privilegeService() {
        return new PrivilegeServiceImpl();
    }

    @Bean
    public HelloWorldService helloWorldService() {
        return new HelloWorldServiceImpl();
    }

}
