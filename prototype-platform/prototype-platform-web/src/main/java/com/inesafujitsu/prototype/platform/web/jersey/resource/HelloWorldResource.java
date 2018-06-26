package com.inesafujitsu.prototype.platform.web.jersey.resource;

import com.inesafujitsu.prototype.platform.service.trial.HelloWorldService;
import com.inesafujitsu.prototype.platform.web.jersey.support.Constants;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path(Constants.ROOT_RESOURCE_HELLO_WORLD)
public class HelloWorldResource {

    @Autowired
    private HelloWorldService helloWorldService;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String sayHelloWorld() {
        return "Hello World";
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path(Constants.SUB_RESOURCE_CHECK_DATABASE)
    public String checkDatabase() {
        return helloWorldService.checkDatabase();
    }
}
