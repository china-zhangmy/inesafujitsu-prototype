package com.inesafujitsu.prototype.business.web.jersey.resource;

import com.inesafujitsu.prototype.business.service.MasterHistoryService;
import com.inesafujitsu.prototype.business.web.jersey.support.Constants;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.Path;

@Path(Constants.ROOT_RESOURCE_TRANSPORT_BOXES)
public class TransportBoxResource extends AbstractMasterHistoryResource {

    @Autowired
    MasterHistoryService transportBoxService;

    @Override
    public MasterHistoryService getService() {
        return transportBoxService;
    }

}
