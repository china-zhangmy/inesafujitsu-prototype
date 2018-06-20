package com.inesafujitsu.prototype.platform.web.jersey.resource;

import com.inesafujitsu.prototype.platform.commons.support.HttpUtils;
import com.inesafujitsu.prototype.platform.model.User;
import com.inesafujitsu.prototype.platform.service.UserService;
import com.inesafujitsu.prototype.platform.web.jersey.support.Constants;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Map;

@Path(Constants.ROOT_RESOURCE_USERS)
public class UserResource {

    @Autowired
    UserService userService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> getAll(@PathParam(Constants.PATH_PARAM_URI) String orgUri) {
        return userService.getAll(orgUri);
    }

    @GET
    @Path(Constants.SUB_RESOURCE_ID)
    @Produces(MediaType.APPLICATION_JSON)
    public User getUser(@PathParam(Constants.PATH_PARAM_ID) String id) {
        return userService.getOne(id);
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public User create(@PathParam(Constants.PATH_PARAM_URI) String orgUri,
                       @NotNull String requestBody) {
        Map<String, Object> userMap = HttpUtils.parseRequestBody(requestBody);

        return userService.create(orgUri, userMap);
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public User update(@PathParam(Constants.PATH_PARAM_URI) String nodeUri,
                       @NotNull String requestBody) {
        Map<String, Object> userMap = HttpUtils.parseRequestBody(requestBody);

        return userService.update(nodeUri, userMap);
    }

    @DELETE
    @Path(Constants.SUB_RESOURCE_ID)
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response remove(@PathParam(Constants.PATH_PARAM_ID) String id) {
        userService.remove(id);

        return Response.ok().build();
    }

}
