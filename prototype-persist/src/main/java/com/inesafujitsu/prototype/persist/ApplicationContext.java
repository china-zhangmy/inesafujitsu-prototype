package com.inesafujitsu.prototype.persist;

import com.inesafujitsu.prototype.persist.ext.CustomVendorDatabaseIdProvider;
import liquibase.integration.spring.SpringLiquibase;
import org.apache.ibatis.mapping.DatabaseIdProvider;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;
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
    public DatabaseIdProvider databaseIdProvider() {
        DatabaseIdProvider databaseIdProvider = new CustomVendorDatabaseIdProvider();

        Properties properties = new Properties();
        properties.setProperty("MySQL", "mysql");
        properties.setProperty("DB2", "db2");
        properties.setProperty("Oracle", "oracle");
        properties.setProperty("SQL Server", "mssql");
        properties.setProperty("PostgreSQL", "postgresql");
        properties.setProperty("Sybase_Enterprise", "sybase");
        properties.setProperty("Sybase_Anywhere", "asany");
        properties.setProperty("Apache_Derby", "derby");
        properties.setProperty("H2", "h2");
        properties.setProperty("Informix", "informix");
        properties.setProperty("Firebird", "firebird");
        properties.setProperty("SQLite", "sqlite");

        databaseIdProvider.setProperties(properties);

        return databaseIdProvider;
    }

}
