package com.inesafujitsu.prototype.business.boot.context;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({com.inesafujitsu.prototype.business.web.context.ApplicationContext.class,
        com.inesafujitsu.prototype.platform.web.context.ApplicationContext.class})
public class ApplicationContext {
}
