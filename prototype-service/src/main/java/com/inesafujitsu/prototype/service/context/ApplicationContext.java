package com.inesafujitsu.prototype.service.context;

import com.inesafujitsu.prototype.model.base.Mask;
import com.inesafujitsu.prototype.model.base.MaskHistory;
import com.inesafujitsu.prototype.service.AbstractMasterHistoryService;
import com.inesafujitsu.prototype.service.DepartmentService;
import com.inesafujitsu.prototype.service.HelloWorldService;
import com.inesafujitsu.prototype.service.UserService;
import com.inesafujitsu.prototype.service.impl.DefaultMasterHistoryServiceImpl;
import com.inesafujitsu.prototype.service.impl.DepartmentServiceImpl;
import com.inesafujitsu.prototype.service.impl.HelloWorldServiceImpl;
import com.inesafujitsu.prototype.service.impl.UserServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.Map;

@Configuration
public class ApplicationContext {

    @Bean
    public PlatformTransactionManager transactionManager(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean
    public AbstractMasterHistoryService<Mask, MaskHistory> maskService() {

        return new DefaultMasterHistoryServiceImpl<Mask, MaskHistory>() {

            @Override
            public Mask buildMaster(Map<String, Object> args) {
                return new Mask.Builder(args).build();
            }

            @Override
            public MaskHistory buildHistory(Map<String, Object> args) {
                return new MaskHistory.Builder(args).build();
            }

        };

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
