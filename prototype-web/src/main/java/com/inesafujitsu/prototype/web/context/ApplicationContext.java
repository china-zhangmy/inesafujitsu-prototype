package com.inesafujitsu.prototype.web.context;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"com.inesafujitsu.prototype.web.*.config"})
public class ApplicationContext {
}
