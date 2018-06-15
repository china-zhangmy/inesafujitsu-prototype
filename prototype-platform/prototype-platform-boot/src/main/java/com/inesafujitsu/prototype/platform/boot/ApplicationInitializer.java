package com.inesafujitsu.prototype.platform.boot;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import java.util.HashMap;
import java.util.Map;

public class ApplicationInitializer extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        Map<String, Object> props = new HashMap<String, Object>();

        props.put("spring.config.location", System.getProperty("config.location", "/config"));
        props.put("spring.config.name", System.getProperty("config.name", "application"));

        return builder.properties(props);
    }
}
