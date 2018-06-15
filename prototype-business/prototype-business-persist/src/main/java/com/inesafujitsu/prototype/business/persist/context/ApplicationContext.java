package com.inesafujitsu.prototype.business.persist.context;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application-persist.properties")
@MapperScan({"com.inesafujitsu.prototype.business.persist.mapper", "com.inesafujitsu.prototype.platform.persist.mapper"})
public class ApplicationContext {

}
