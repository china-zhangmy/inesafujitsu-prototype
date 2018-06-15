package com.inesafujitsu.prototype.business.web.jersey.config;

import com.inesafujitsu.prototype.business.web.jersey.support.Constants;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import javax.ws.rs.ApplicationPath;

@Component
@ApplicationPath(Constants.APPLICATION_ROOT_RESOURCE)
@Profile("business")
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {
        packages("com.inesafujitsu.prototype.business.web.jersey.resource",
                "com.inesafujitsu.prototype.platform.web.jersey.resource");
    }

}
