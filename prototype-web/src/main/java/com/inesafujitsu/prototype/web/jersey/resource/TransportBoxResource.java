package com.inesafujitsu.prototype.web.jersey.resource;

import com.inesafujitsu.prototype.service.AbstractMasterHistoryService;
import com.inesafujitsu.prototype.web.jersey.support.Constants;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.Path;

@Path(Constants.RESOURCE_ROOT_TRANSPORT_BOXES)
public class TransportBoxResource extends AbstractMasterHistoryResource {

    @Autowired
    AbstractMasterHistoryService transportBoxService;

    @Override
    public AbstractMasterHistoryService getService() {
        return transportBoxService;
    }

}
