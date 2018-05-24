package com.inesafujitsu.prototype.persist.context;

import liquibase.integration.spring.SpringLiquibase;
import org.apache.ibatis.mapping.DatabaseIdProvider;
import org.apache.ibatis.mapping.VendorDatabaseIdProvider;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@Configuration
@PropertySource("classpath:application-persist.properties")
@MapperScan("com.inesafujitsu.prototype.persist.mapper")
public class ApplicationContext {

//    @Bean
//    public DataSource dataSource(Environment env) {
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//
//        dataSource.setDriverClassName(env.getProperty("spring.datasource.driverClassName"));
//        dataSource.setUrl(env.getProperty("spring.datasource.url"));
//        dataSource.setUsername(env.getProperty("spring.datasource.username"));
//        dataSource.setPassword(env.getProperty("spring.datasource.password"));
//
//        return dataSource;
//    }

    @Bean
    public SpringLiquibase liquibase(DataSource dataSource) {
        SpringLiquibase liquibase = new SpringLiquibase();

        liquibase.setDataSource(dataSource);
        liquibase.setChangeLog("classpath:db/changelog/changelog-master.xml");
        liquibase.setShouldRun(false);

        return liquibase;
    }

    @Bean
    public DatabaseIdProvider databaseIdProvider() throws IOException {
        DatabaseIdProvider databaseIdProvider = new VendorDatabaseIdProvider();

        InputStream is = getClass().getClassLoader().getResourceAsStream("db_vendor.properties");
        Properties properties = new Properties();
        properties.load(is);

        databaseIdProvider.setProperties(properties);

        return databaseIdProvider;
    }

}
