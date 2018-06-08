package com.inesafujitsu.prototype.web.jersey.resource;

import com.inesafujitsu.prototype.service.RelationService;
import com.inesafujitsu.prototype.web.jersey.support.Constants;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.DELETE;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

@Path(Constants.RESOURCE_ROOT_RELATION)
public class RelationResource {

    @Autowired
    RelationService relationService;

    @PUT
    @Path(Constants.RESOURCE_RELATION_BINDING)
    public Response bind(@PathParam(Constants.PATH_PARAM_RELATION_X_ENTITY_NAME) String xEntityName,
                         @PathParam(Constants.PATH_PARAM_RELATION_X_ID) String xId,
                         @PathParam(Constants.PATH_PARAM_RELATION_Y_ENTITY_NAME) String yEntityName,
                         @PathParam(Constants.PATH_PARAM_RELATION_Y_ID) String yId) {

        relationService.bind(xEntityName, xId, yEntityName, yId);

        return Response.ok().build();
    }

    @DELETE
    @Path(Constants.RESOURCE_RELATION_UNBINDING)
    public Response unbind(@PathParam(Constants.PATH_PARAM_RELATION_X_ENTITY_NAME) String xEntityName,
                           @PathParam(Constants.PATH_PARAM_RELATION_X_ID) String xId,
                           @PathParam(Constants.PATH_PARAM_RELATION_Y_ENTITY_NAME) String yEntityName,
                           @PathParam(Constants.PATH_PARAM_RELATION_Y_ID) String yId) {

        relationService.unbind(xEntityName, xId, yEntityName, yId);

        return Response.ok().build();
    }

}
