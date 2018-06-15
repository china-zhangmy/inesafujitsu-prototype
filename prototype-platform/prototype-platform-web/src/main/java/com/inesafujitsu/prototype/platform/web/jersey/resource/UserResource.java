package com.inesafujitsu.prototype.platform.web.jersey.resource;

import com.inesafujitsu.prototype.platform.model.User;
import com.inesafujitsu.prototype.platform.service.UserService;
import com.inesafujitsu.prototype.platform.web.jersey.support.Constants;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path(Constants.ROOT_RESOURCE_USER)
public class UserResource {

    @Autowired
    UserService userService;

    @GET
    @Path(Constants.SUB_RESOURCE_ID)
    @Produces(MediaType.APPLICATION_JSON)
    public User getUser(@PathParam(Constants.PATH_PARAM_ID) String id) {
        return userService.getOne(id);
    }

}
