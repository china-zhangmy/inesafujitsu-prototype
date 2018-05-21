package com.inesafujitsu.prototype.web.webservice.resource;

import com.inesafujitsu.prototype.web.webservice.constant.PathConstant;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path(PathConstant.TEST_RESOURCE_ROOT)
public class TestResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String sayHelloWorld() {
        return "Hello World";
    }
}
