package com.inesafujitsu.prototype.platform.web.jersey.resource;

import com.inesafujitsu.prototype.platform.commons.support.HttpUtils;
import com.inesafujitsu.prototype.platform.model.orgchart.Group;
import com.inesafujitsu.prototype.platform.service.orgchart.GroupService;
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

//@Path(Constants.ROOT_RESOURCE_USER_GROUPS)
@Component
@Singleton
public class GroupResource {

    @Autowired
    private GroupService groupService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Group> getAll(@PathParam(Constants.PATH_PARAM_URI) String orgUri) {
        return groupService.getAll(orgUri);
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Group create(@PathParam(Constants.PATH_PARAM_URI) String orgUri,
                        @NotNull String requestBody) {
        Map<String, Object> args = HttpUtils.parseRequestBody(requestBody);

        return groupService.create(orgUri, args);
    }

    @Path(Constants.SUB_RESOURCE_LOCATOR_GROUP_ID)
    public Class<IdSpecificGroupResource> idSpecificGroupResourceLocator() {
        return IdSpecificGroupResource.class;
    }

    @Singleton
    public static class IdSpecificGroupResource {

        @Autowired
        private GroupService groupService;

        @GET
        @Produces(MediaType.APPLICATION_JSON)
        public Group getOne(@PathParam(Constants.PATH_PARAM_GROUP_ID) String id) {
            return groupService.getOne(id);
        }

        @PUT
        @Produces(MediaType.APPLICATION_JSON)
        @Consumes(MediaType.APPLICATION_JSON)
        public Group update(@PathParam(Constants.PATH_PARAM_URI) String orgUri,
                            @PathParam(Constants.PATH_PARAM_GROUP_ID) String id,
                            @NotNull String requestBody) {
            Map<String, Object> args = HttpUtils.parseRequestBody(requestBody);

            return groupService.update(orgUri, id, args);
        }

        @DELETE
        @Produces(MediaType.APPLICATION_JSON)
        @Consumes(MediaType.APPLICATION_JSON)
        public Response remove(@PathParam(Constants.PATH_PARAM_GROUP_ID) String id) {
            groupService.remove(id);

            return Response.ok().build();
        }

        @Path(Constants.SUB_RESOURCE_LOCATOR_USERS)
        public Class<UserResource> userResourceLocator() {
            return UserResource.class;
        }

    }
}
