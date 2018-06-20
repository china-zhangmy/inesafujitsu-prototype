package com.inesafujitsu.prototype.business.service.context;

import com.inesafujitsu.prototype.business.model.Mask;
import com.inesafujitsu.prototype.business.model.MaskHistory;
import com.inesafujitsu.prototype.business.model.TransportBox;
import com.inesafujitsu.prototype.business.model.TransportBoxHistory;
import com.inesafujitsu.prototype.business.service.*;
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
    public MasterHistoryService maskService(MasterService<Mask> maskMasterService,
                                            HistoryService<MaskHistory> maskHistoryService) {
        return new DefaultMasterHistoryServiceImpl<>(maskMasterService, maskHistoryService);
    }

    @Bean
    public MasterService<Mask> maskMasterService() {
        return new AbstractMasterService<Mask>() {

            @Override
            protected Mask buildMaster(Map<String, Object> args) {
                return new Mask.Builder(args).build();
            }
        };
    }

    @Bean
    public HistoryService<MaskHistory> maskHistoryService() {
        return new AbstractHistoryService<MaskHistory>() {

            @Override
            public MaskHistory buildHistory(Map<String, Object> args) {
                return new MaskHistory.Builder(args).build();
            }
        };
    }

    @Bean
    public MasterHistoryService transportBoxService(MasterService<TransportBox> transportBoxMasterService,
                                                    HistoryService<TransportBoxHistory> transportBoxHistoryService) {
        return new DefaultMasterHistoryServiceImpl<>(transportBoxMasterService, transportBoxHistoryService);
    }

    @Bean
    public MasterService<TransportBox> transportBoxMasterService() {
        return new AbstractMasterService<TransportBox>() {

            @Override
            protected TransportBox buildMaster(Map args) {
                return new TransportBox.Builder(args).build();
            }
        };
    }

    @Bean
    public HistoryService<TransportBoxHistory> transportBoxHistoryService() {
        return new AbstractHistoryService<TransportBoxHistory>() {

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
