package com.inesafujitsu.prototype.web.jersey.config;

import com.inesafujitsu.prototype.web.jersey.support.Constants;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import javax.ws.rs.ApplicationPath;

@Component
@ApplicationPath(Constants.RESOURCE_APPLICATION_ROOT)
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {
        packages("com.inesafujitsu.prototype.web.jersey.resource");
    }

}
