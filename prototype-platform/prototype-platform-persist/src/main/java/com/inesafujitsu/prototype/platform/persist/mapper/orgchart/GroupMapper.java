package com.inesafujitsu.prototype.platform.persist.mapper.orgchart;

import com.inesafujitsu.prototype.platform.model.orgchart.Group;
import com.inesafujitsu.prototype.platform.persist.mapper.abs.AbstractMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GroupMapper extends AbstractMapper<Group> {

    List<Group> getAll(@Param("orgUri") String orgUri);

}
