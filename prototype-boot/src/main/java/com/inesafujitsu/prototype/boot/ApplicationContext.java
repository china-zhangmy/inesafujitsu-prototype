package com.inesafujitsu.prototype.boot;

import com.inesafujitsu.prototype.web.WebApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({WebApplicationContext.class})
public class ApplicationContext {
}
