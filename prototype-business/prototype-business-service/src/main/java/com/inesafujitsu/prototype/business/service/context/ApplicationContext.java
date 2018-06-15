package com.inesafujitsu.prototype.business.service.context;

import com.inesafujitsu.prototype.business.model.Mask;
import com.inesafujitsu.prototype.business.model.MaskHistory;
import com.inesafujitsu.prototype.business.model.TransportBox;
import com.inesafujitsu.prototype.business.model.TransportBoxHistory;
import com.inesafujitsu.prototype.business.service.AbstractMasterHistoryService;
import com.inesafujitsu.prototype.business.service.RelationService;
import com.inesafujitsu.prototype.business.service.impl.DefaultMasterHistoryServiceImpl;
import com.inesafujitsu.prototype.business.service.impl.RelationServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.Map;

@Configuration
@Import({com.inesafujitsu.prototype.business.persist.context.ApplicationContext.class})
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


}
