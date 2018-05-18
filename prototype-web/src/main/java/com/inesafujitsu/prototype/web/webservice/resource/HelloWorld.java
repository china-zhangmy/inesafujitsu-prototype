package com.inesafujitsu.prototype.web.webservice.resource;

import com.inesafujitsu.prototype.web.webservice.constant.PathConstant;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path(PathConstant.HELLO_WORLD_ROOT)
public class HelloWorld {

    @GET
    @Produces("text/plain")
    public String sayHelloWorld() {
        return "Hello World";
    }
}
