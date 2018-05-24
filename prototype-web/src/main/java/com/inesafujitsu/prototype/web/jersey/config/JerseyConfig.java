package com.inesafujitsu.prototype.web.jersey.config;

import com.inesafujitsu.prototype.web.jersey.constant.PathConstant;
import com.inesafujitsu.prototype.web.jersey.resource.DepartmentResource;
import com.inesafujitsu.prototype.web.jersey.resource.HelloWorldResource;
import com.inesafujitsu.prototype.web.jersey.resource.UserResource;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import javax.ws.rs.ApplicationPath;

@Component
@ApplicationPath(PathConstant.APPLICATION_ROOT)
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {
        register(HelloWorldResource.class);
        register(UserResource.class);
        register(DepartmentResource.class);
    }

}
