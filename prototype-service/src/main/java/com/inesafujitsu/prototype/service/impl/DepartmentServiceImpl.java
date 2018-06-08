package com.inesafujitsu.prototype.service.impl;

import com.inesafujitsu.prototype.model.platform.Department;
import com.inesafujitsu.prototype.persist.mapper.DepartmentMapper;
import com.inesafujitsu.prototype.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;

public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    DepartmentMapper departmentMapper;

    public Department getOne(String id) {
        return departmentMapper.getOne(id);
    }

}
