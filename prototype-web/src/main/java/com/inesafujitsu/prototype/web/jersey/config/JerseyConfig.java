package com.inesafujitsu.prototype.web.jersey.config;

import com.inesafujitsu.prototype.web.jersey.resource.DepartmentResource;
import com.inesafujitsu.prototype.web.jersey.resource.HelloWorldResource;
import com.inesafujitsu.prototype.web.jersey.resource.MaskResource;
import com.inesafujitsu.prototype.web.jersey.resource.UserResource;
import com.inesafujitsu.prototype.web.jersey.support.Constants;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import javax.ws.rs.ApplicationPath;

@Component
@ApplicationPath(Constants.RESOURCE_APPLICATION_ROOT)
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {
        register(HelloWorldResource.class);
        register(UserResource.class);
        register(DepartmentResource.class);
        register(MaskResource.class);
    }

}
