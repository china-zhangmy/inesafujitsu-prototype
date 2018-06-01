package com.inesafujitsu.prototype.web.jersey.resource;

import com.inesafujitsu.prototype.common.JsonUtils;
import com.inesafujitsu.prototype.model.base.History;
import com.inesafujitsu.prototype.model.base.Master;
import com.inesafujitsu.prototype.service.AbstractMasterHistoryService;
import com.inesafujitsu.prototype.web.jersey.support.Constants;

import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.Map;

public abstract class AbstractMasterHistoryResource {

    public abstract AbstractMasterHistoryService getService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Master> getAllMasters() {
        return getService().getAllMasters();
    }

    @GET
    @Path(Constants.RESOURCE_ONE)
    @Produces(MediaType.APPLICATION_JSON)
    public Master getMaster(@NotNull @PathParam(Constants.PATH_PARAM_ID) String id) {
        return getService().getMaster(id);
    }

    @GET
    @Path(Constants.RESOURCE_ONE_MASTER_ALL_HISTORIES)
    @Produces(MediaType.APPLICATION_JSON)
    public List<History> getAllHistories(@NotNull @PathParam(Constants.PATH_PARAM_MASTER_ID) String masterId) {
        return getService().getAllHistories(masterId);
    }

    @GET
    @Path(Constants.RESOURCE_ONE_MASTER_ONE_HISTORY)
    @Produces(MediaType.APPLICATION_JSON)
    public History getHistory(@NotNull @PathParam(Constants.PATH_PARAM_MASTER_ID) String masterId,
                              @NotNull @PathParam(Constants.PATH_PARAM_IDX) Integer idx) {
        return getService().getHistory(masterId, idx);
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Master createMask(@NotNull String body) {
        Map maskMap = JsonUtils.jsonToMap(body);

        if (maskMap == null) {
            return null;
        }

        return getService().createMaster(maskMap);
    }

    @PUT
    @Path(Constants.RESOURCE_ONE)
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Master updateMaster(@NotNull @PathParam(Constants.PATH_PARAM_ID) String id,
                               @QueryParam(Constants.QUERY_PARAM_OPERATOR) String operator,
                               String body) {

        if (getService().validateOperation(operator)) {
            Map<String, Object> masterMap = JsonUtils.jsonToMap(body);

            return getService().updateMaster(id, operator, masterMap);
        }

        throw new RuntimeException();
    }

}
