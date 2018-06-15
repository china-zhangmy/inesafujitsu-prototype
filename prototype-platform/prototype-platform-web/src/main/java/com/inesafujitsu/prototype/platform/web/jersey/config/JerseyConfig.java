package com.inesafujitsu.prototype.platform.web.jersey.config;

import com.inesafujitsu.prototype.platform.web.jersey.support.Constants;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import javax.ws.rs.ApplicationPath;

@Component
@ApplicationPath(Constants.APPLICATION_ROOT_RESOURCE)
@Profile("platform")
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {
        packages("com.inesafujitsu.prototype.platform.web.jersey.resource");
    }

}
