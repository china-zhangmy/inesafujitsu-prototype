package com.inesafujitsu.prototype.web.webservice.config;

import com.inesafujitsu.prototype.web.webservice.constant.PathConstant;
import com.inesafujitsu.prototype.web.webservice.resource.HelloWorld;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import javax.ws.rs.ApplicationPath;

@Component
@ApplicationPath(PathConstant.APPLICATION_ROOT)
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {
        register(HelloWorld.class);
    }

}
