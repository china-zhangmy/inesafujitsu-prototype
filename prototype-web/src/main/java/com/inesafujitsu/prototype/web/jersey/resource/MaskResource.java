package com.inesafujitsu.prototype.web.jersey.resource;

import com.inesafujitsu.prototype.model.base.Mask;
import com.inesafujitsu.prototype.model.base.MaskHistory;
import com.inesafujitsu.prototype.service.AbstractMasterHistoryService;
import com.inesafujitsu.prototype.web.jersey.support.Constants;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.Path;

@Path(Constants.RESOURCE_ROOT_MASK)
public class MaskResource extends AbstractMasterHistoryResource {

    @Autowired
    AbstractMasterHistoryService<Mask, MaskHistory> maskService;

    @Override
    public AbstractMasterHistoryService getService() {
        return maskService;
    }

}
