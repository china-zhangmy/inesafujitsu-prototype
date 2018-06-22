package com.inesafujitsu.prototype.business.web.context;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan({"com.inesafujitsu.prototype.*.web.jersey"})
@Import({com.inesafujitsu.prototype.business.service.context.ApplicationContext.class})
public class ApplicationContext {
}
