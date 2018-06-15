package com.inesafujitsu.prototype.business.web.jersey.resource;

import com.inesafujitsu.prototype.business.service.AbstractMasterHistoryService;
import com.inesafujitsu.prototype.business.web.jersey.support.Constants;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.Path;

@Path(Constants.ROOT_RESOURCE_TRANSPORT_BOXES)
public class TransportBoxResource extends AbstractMasterHistoryResource {

    @Autowired
    AbstractMasterHistoryService transportBoxService;

    @Override
    public AbstractMasterHistoryService getService() {
        return transportBoxService;
    }

}
