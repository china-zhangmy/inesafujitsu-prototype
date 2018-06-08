package com.inesafujitsu.prototype.web.jersey.resource;

import com.inesafujitsu.prototype.common.JsonUtils;
import com.inesafujitsu.prototype.service.AbstractMasterHistoryService;
import com.inesafujitsu.prototype.service.support.UpdateOpt;
import com.inesafujitsu.prototype.service.support.Validator;
import com.inesafujitsu.prototype.web.jersey.support.Constants;
import org.apache.commons.lang3.StringUtils;

import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.Map;

public abstract class AbstractMasterHistoryResource {

    public abstract AbstractMasterHistoryService getService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List getAllMasters() {
        return getService().getAllMasters();
    }

    @GET
    @Path(Constants.RESOURCE_ONE)
    @Produces(MediaType.APPLICATION_JSON)
    public Object getMaster(@NotNull @PathParam(Constants.PATH_PARAM_ID) String id) {
        return getService().getMaster(id);
    }

    @GET
    @Path(Constants.RESOURCE_ONE_MASTER_ALL_HISTORIES)
    @Produces(MediaType.APPLICATION_JSON)
    public List getAllHistories(@NotNull @PathParam(Constants.PATH_PARAM_MASTER_ID) String masterId) {
        return getService().getAllHistories(masterId);
    }

    @GET
    @Path(Constants.RESOURCE_ONE_MASTER_ONE_HISTORY)
    @Produces(MediaType.APPLICATION_JSON)
    public Object getHistory(@NotNull @PathParam(Constants.PATH_PARAM_MASTER_ID) String masterId,
                             @NotNull @PathParam(Constants.PATH_PARAM_IDX) Integer idx) {
        return getService().getHistory(masterId, idx);
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Object createMaster(@NotNull String body) {
        Map masterMap = JsonUtils.jsonToMap(body);

        if (masterMap == null) {
            return null;
        }

        return getService().createMaster(masterMap);
    }

    @PUT
    @Path(Constants.RESOURCE_ONE)
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Object updateMaster(@NotNull @PathParam(Constants.PATH_PARAM_ID) String id,
                               String requestBody) {

        if (StringUtils.isBlank(requestBody) || JsonUtils.jsonToMap(requestBody).isEmpty()) {
            throw new RuntimeException("Not Allowed Operation");
        }

        Map<String, Object> requestBodyMap = JsonUtils.jsonToMap(requestBody);
        String operator = (String) requestBodyMap.get("operator");

        if (!Validator.isValidUpdateOpt(operator)) {
            throw new RuntimeException("Not Allowed Operation");
        }

        switch (UpdateOpt.lookup(operator)) {
            case CHECK_OUT:
                return getService().checkOutMaster(id);
            case CHECK_IN:
                return getService().checkInMaster(id);
            default:
                Map<String, Object> masterMap = (Map<String, Object>) requestBodyMap.get("master");
                return getService().updateMaster(id, masterMap);
        }
    }

}
