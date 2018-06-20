package com.inesafujitsu.prototype.business.web.jersey.resource;

import com.inesafujitsu.prototype.business.model.abs.History;
import com.inesafujitsu.prototype.business.model.abs.Master;
import com.inesafujitsu.prototype.business.service.MasterHistoryService;
import com.inesafujitsu.prototype.business.service.support.UpdateOpt;
import com.inesafujitsu.prototype.business.service.support.Validator;
import com.inesafujitsu.prototype.business.web.jersey.support.Constants;
import com.inesafujitsu.prototype.platform.commons.support.HttpUtils;

import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Map;

public abstract class AbstractMasterHistoryResource {

    public abstract MasterHistoryService getService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Master> getAllMasters() {
        return getService().getAllMasters();
    }

    @GET
    @Path(Constants.SUB_RESOURCE_ID)
    @Produces(MediaType.APPLICATION_JSON)
    public Master getMaster(@PathParam(Constants.PATH_PARAM_ID) String id) {
        return getService().getMaster(id);
    }

    @GET
    @Path(Constants.SUB_RESOURCE_ONE_MASTER_ALL_HISTORIES)
    @Produces(MediaType.APPLICATION_JSON)
    public List<History> getAllHistories(@PathParam(Constants.PATH_PARAM_MASTER_ID) String masterId) {
        return getService().getAllHistories(masterId);
    }

    @GET
    @Path(Constants.SUB_RESOURCE_ONE_MASTER_ONE_HISTORY)
    @Produces(MediaType.APPLICATION_JSON)
    public History getHistory(@PathParam(Constants.PATH_PARAM_MASTER_ID) String masterId,
                              @PathParam(Constants.PATH_PARAM_IDX) Integer idx) {
        return getService().getHistory(masterId, idx);
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Master createMaster(@NotNull String requestBody) {
        Map masterMap = HttpUtils.parseRequestBody(requestBody);

        return getService().create(masterMap);
    }

    @PUT
    @Path(Constants.SUB_RESOURCE_ID)
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Master updateMaster(@PathParam(Constants.PATH_PARAM_ID) String id,
                               String requestBody) {
        Map<String, Object> requestBodyMap = HttpUtils.parseRequestBody(requestBody);

        if (requestBodyMap.isEmpty()) {
            throw new RuntimeException("Not Allowed Operation");
        }

        String operator = (String) requestBodyMap.get("operator");

        if (!Validator.isValidUpdateOpt(operator)) {
            throw new RuntimeException("Not Allowed Operation");
        }

        switch (UpdateOpt.lookup(operator)) {
            case CHECK_OUT:
                return getService().checkOut(id);
            case CHECK_IN:
                return getService().checkIn(id);
            default:
                Map<String, Object> masterMap = (Map<String, Object>) requestBodyMap.get("master");
                return getService().update(id, masterMap);
        }
    }

    @DELETE
    @Path(Constants.SUB_RESOURCE_ID)
    @Produces(MediaType.APPLICATION_JSON)
    public Response removeMaster(@PathParam(Constants.PATH_PARAM_ID) String id) {
        getService().remove(id);

        return Response.ok().build();
    }

}
