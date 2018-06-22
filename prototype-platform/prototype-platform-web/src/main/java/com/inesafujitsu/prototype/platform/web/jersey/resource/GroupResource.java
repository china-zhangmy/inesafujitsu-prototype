package com.inesafujitsu.prototype.platform.web.jersey.resource;

import com.inesafujitsu.prototype.platform.commons.support.HttpUtils;
import com.inesafujitsu.prototype.platform.model.User;
import com.inesafujitsu.prototype.platform.service.UserService;
import com.inesafujitsu.prototype.platform.web.jersey.support.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.inject.Singleton;
import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Map;

//@Path(Constants.ROOT_RESOURCE_GROUPS)
@Component
@Singleton
public class GroupResource {

    @Autowired
    UserService userService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> getAll(@PathParam(Constants.PATH_PARAM_URI) String orgUri) {
        return userService.getAll(orgUri, User.Type.GROUP, null);
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public User create(@PathParam(Constants.PATH_PARAM_URI) String orgUri,
                       @NotNull String requestBody) {
        Map<String, Object> args = HttpUtils.parseRequestBody(requestBody);

        return userService.createGroup(orgUri, args);
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public User update(@PathParam(Constants.PATH_PARAM_URI) String nodeUri,
                       @NotNull String requestBody) {
        Map<String, Object> args = HttpUtils.parseRequestBody(requestBody);

        return userService.update(nodeUri, args);
    }

    @Path(Constants.SUB_RESOURCE_LOCATOR_GROUP_ID)
    public Class<IdSpecificGroupResource> idSpecificGroupResourceLocator() {
        return IdSpecificGroupResource.class;
    }

    @Singleton
    public static class IdSpecificGroupResource {

        @Autowired
        UserService userService;

        @GET
        @Produces(MediaType.APPLICATION_JSON)
        public User getOne(@PathParam(Constants.PATH_PARAM_GROUP_ID) String id) {
            return userService.getOne(id);
        }

        @DELETE
        @Produces(MediaType.APPLICATION_JSON)
        @Consumes(MediaType.APPLICATION_JSON)
        public Response remove(@PathParam(Constants.PATH_PARAM_GROUP_ID) String id) {
            userService.remove(id);

            return Response.ok().build();
        }

        @Path(Constants.SUB_RESOURCE_LOCATOR_USERS)
        public Class<UserResource> userResourceLocator() {
            return UserResource.class;
        }

    }
}
