package com.inesafujitsu.prototype.platform.boot.context;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({com.inesafujitsu.prototype.platform.web.context.ApplicationContext.class})
public class ApplicationContext {
}
