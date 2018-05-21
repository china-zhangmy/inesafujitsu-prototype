package com.inesafujitsu.prototype.boot;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({com.inesafujitsu.prototype.web.ApplicationContext.class,
        com.inesafujitsu.prototype.service.ApplicationContext.class,
        com.inesafujitsu.prototype.persist.ApplicationContext.class})
public class ApplicationContext {
}
