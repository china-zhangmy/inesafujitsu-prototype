package com.inesafujitsu.prototype.platform.web.context;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan({"com.inesafujitsu.prototype.platform.web.jersey"})
@Import({com.inesafujitsu.prototype.platform.service.context.ApplicationContext.class})
public class ApplicationContext {
}
