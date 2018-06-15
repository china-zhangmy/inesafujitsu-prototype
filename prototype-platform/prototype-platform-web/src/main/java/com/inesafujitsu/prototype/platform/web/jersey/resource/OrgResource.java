package com.inesafujitsu.prototype.platform.web.jersey.resource;

import com.inesafujitsu.prototype.platform.commons.support.HttpUtils;
import com.inesafujitsu.prototype.platform.model.Org;
import com.inesafujitsu.prototype.platform.service.OrgService;
import com.inesafujitsu.prototype.platform.web.jersey.support.Constants;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.Map;

@Path(Constants.ROOT_RESOURCE_ORGANIZATIONS)
public class OrgResource {

    @Autowired
    OrgService orgService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Org> getAll() {
        return orgService.getAll();
    }

    @GET
    @Path(Constants.SUB_RESOURCE_URI)
    @Produces(MediaType.APPLICATION_JSON)
    public Org findOne(@NotNull @PathParam(Constants.PATH_PARAM_URI) String uri) {
        return orgService.findByUri(uri);
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Org createCompany(@NotNull String requestBody) {
        Map<String, Object> nodeMap = HttpUtils.parseRequestBody(requestBody);

        return orgService.createCompany(nodeMap);
    }

    @POST
    @Path(Constants.SUB_RESOURCE_URI)
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Org addChild(@PathParam(Constants.PATH_PARAM_URI) String nodeUri,
                        @NotNull String requestBody) {
        Map<String, Object> childNodeMap = HttpUtils.parseRequestBody(requestBody);

        return orgService.addChild(nodeUri, childNodeMap);
    }

    @PUT
    @Path(Constants.SUB_RESOURCE_URI)
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Org update(@PathParam(Constants.PATH_PARAM_URI) String nodeUri,
                      @NotNull String requestBody) {
        Map<String, Object> childNodeMap = HttpUtils.parseRequestBody(requestBody);

        return orgService.update(nodeUri, childNodeMap);
    }

    @DELETE
    @Path(Constants.SUB_RESOURCE_URI)
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Org remove(@PathParam(Constants.PATH_PARAM_URI) String nodeUri) {
        return orgService.remove(nodeUri);
    }

}
