package com.inesafujitsu.prototype.boot.context;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({com.inesafujitsu.prototype.web.context.ApplicationContext.class,
        com.inesafujitsu.prototype.service.context.ApplicationContext.class,
        com.inesafujitsu.prototype.persist.context.ApplicationContext.class})
public class ApplicationContext {
}
