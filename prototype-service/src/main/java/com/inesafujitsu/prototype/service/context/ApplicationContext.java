package com.inesafujitsu.prototype.service.context;

import com.inesafujitsu.prototype.model.business.Mask;
import com.inesafujitsu.prototype.model.business.MaskHistory;
import com.inesafujitsu.prototype.model.business.TransportBox;
import com.inesafujitsu.prototype.model.business.TransportBoxHistory;
import com.inesafujitsu.prototype.service.*;
import com.inesafujitsu.prototype.service.impl.*;
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
    public AbstractMasterHistoryService maskService() {

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
    public AbstractMasterHistoryService transportBoxService() {

        return new DefaultMasterHistoryServiceImpl<TransportBox, TransportBoxHistory>() {

            @Override
            public TransportBox buildMaster(Map<String, Object> args) {
                return new TransportBox.Builder(args).build();
            }

            @Override
            public TransportBoxHistory buildHistory(Map<String, Object> args) {
                return new TransportBoxHistory.Builder(args).build();
            }

        };

    }

    @Bean
    public RelationService relationService() {
        return new RelationServiceImpl();
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
