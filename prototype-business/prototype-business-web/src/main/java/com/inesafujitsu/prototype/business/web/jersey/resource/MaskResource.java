package com.inesafujitsu.prototype.business.web.jersey.resource;

import com.inesafujitsu.prototype.business.service.MasterHistoryService;
import com.inesafujitsu.prototype.business.web.jersey.support.Constants;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.Path;

@Path(Constants.ROOT_RESOURCE_MASK)
public class MaskResource extends AbstractMasterHistoryResource {

    @Autowired
    MasterHistoryService maskService;

    @Override
    public MasterHistoryService getService() {
        return maskService;
    }

}
