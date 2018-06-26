package com.inesafujitsu.prototype.platform.persist.mapper.ctrl;

import com.inesafujitsu.prototype.platform.model.ctrl.Privilege;
import com.inesafujitsu.prototype.platform.persist.mapper.abs.AbstractMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PrivilegeMapper extends AbstractMapper<Privilege> {

    List<Privilege> getAll(@Param("type") Privilege.Type type);

    Privilege getOne(String code);

}
