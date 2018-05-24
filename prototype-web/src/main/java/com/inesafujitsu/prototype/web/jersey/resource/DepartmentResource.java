package com.inesafujitsu.prototype.web.jersey.resource;

import com.inesafujitsu.prototype.model.Department;
import com.inesafujitsu.prototype.service.DepartmentService;
import com.inesafujitsu.prototype.web.jersey.constant.ParaConstant;
import com.inesafujitsu.prototype.web.jersey.constant.PathConstant;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path(PathConstant.DEPARTMENT_RESOURCE_ROOT)
public class DepartmentResource {

    @Autowired
    DepartmentService departmentService;

    @GET
    @Path(PathConstant.DEPARTMENT_RESOURCE_ONE)
    @Produces(MediaType.APPLICATION_JSON)
    public Department getDepartment(@PathParam(ParaConstant.PATH_PARAM_ID) Long id) {
        return departmentService.getOne(id);
    }

}
