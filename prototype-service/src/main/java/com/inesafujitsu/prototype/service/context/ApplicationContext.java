package com.inesafujitsu.prototype.service.context;

import com.inesafujitsu.prototype.service.DepartmentService;
import com.inesafujitsu.prototype.service.HelloWorldService;
import com.inesafujitsu.prototype.service.UserService;
import com.inesafujitsu.prototype.service.impl.DepartmentServiceImpl;
import com.inesafujitsu.prototype.service.impl.HelloWorldServiceImpl;
import com.inesafujitsu.prototype.service.impl.UserServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Configuration
public class ApplicationContext {

    @Bean
    public PlatformTransactionManager transactionManager(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean
    public UserService userService() {
        return new UserServiceImpl();
    }

    @Bean
    public DepartmentService departmentService() {
        return new DepartmentServiceImpl();
    }

    @Bean
    public HelloWorldService helloWorldService() {
        return new HelloWorldServiceImpl();
    }

}
