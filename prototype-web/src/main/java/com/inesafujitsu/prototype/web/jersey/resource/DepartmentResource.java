package com.inesafujitsu.prototype.web.jersey.resource;

import com.inesafujitsu.prototype.model.platform.Department;
import com.inesafujitsu.prototype.service.DepartmentService;
import com.inesafujitsu.prototype.web.jersey.support.Constants;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path(Constants.RESOURCE_ROOT_DEPARTMENT)
public class DepartmentResource {

    @Autowired
    DepartmentService departmentService;

    @GET
    @Path(Constants.RESOURCE_ONE)
    @Produces(MediaType.APPLICATION_JSON)
    public Department getDepartment(@PathParam(Constants.PATH_PARAM_ID) String id) {
        return departmentService.getOne(id);
    }

}
