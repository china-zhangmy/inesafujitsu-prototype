package com.inesafujitsu.prototype.web.webservice.resource;

import com.inesafujitsu.prototype.model.User;
import com.inesafujitsu.prototype.service.UserService;
import com.inesafujitsu.prototype.web.webservice.constant.ParaConstant;
import com.inesafujitsu.prototype.web.webservice.constant.PathConstant;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path(PathConstant.USER_RESOURCE_ROOT)
public class UserResource {

    @Autowired
    UserService userService;

    @GET
    @Path(PathConstant.USER_RESOURCE_ONE)
    @Produces(MediaType.APPLICATION_JSON)
    public User getUser(@PathParam(ParaConstant.PATH_PARAM_ID) Long id) {
        return userService.getUser(id);
    }

}
