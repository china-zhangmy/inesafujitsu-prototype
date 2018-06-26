package com.inesafujitsu.prototype.platform.web.jersey.resource;

import com.inesafujitsu.prototype.platform.commons.support.HttpUtils;
import com.inesafujitsu.prototype.platform.model.ctrl.Privilege;
import com.inesafujitsu.prototype.platform.service.ctrl.PrivilegeService;
import com.inesafujitsu.prototype.platform.web.jersey.support.Constants;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Map;

@Path(Constants.ROOT_RESOURCE_PRIVILEGES)
public class PrivilegeResource {

    @Autowired
    PrivilegeService privilegeService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Privilege> getAll(@QueryParam(Constants.QUERY_PARAM_TYPE_CODE) String typeCode) {
        return privilegeService.getAll(typeCode);
    }

    @GET
    @Path(Constants.SUB_RESOURCE_CODE)
    @Produces(MediaType.APPLICATION_JSON)
    public Privilege getOne(@PathParam(Constants.PATH_PARAM_CODE) String code) {
        return privilegeService.getOne(code);
    }

    @PUT
    @Path(Constants.SUB_RESOURCE_CODE)
    @Produces(MediaType.APPLICATION_JSON)
    public Privilege createOrUpdate(@PathParam(Constants.PATH_PARAM_CODE) String code,
                                    @NotNull String requestBody) {
        Map<String, Object> args = HttpUtils.parseRequestBody(requestBody);

        return privilegeService.createOrUpdate(code, args);
    }

    @DELETE
    @Path((Constants.SUB_RESOURCE_CODE))
    @Produces(MediaType.APPLICATION_JSON)
    public Response remove(@PathParam(Constants.PATH_PARAM_CODE) String code) {
        privilegeService.remove(code);

        return Response.ok().build();
    }


}
