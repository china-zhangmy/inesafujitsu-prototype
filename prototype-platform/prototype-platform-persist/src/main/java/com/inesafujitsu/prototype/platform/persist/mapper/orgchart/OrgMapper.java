package com.inesafujitsu.prototype.platform.persist.mapper.orgchart;

import com.inesafujitsu.prototype.platform.model.orgchart.Org;
import com.inesafujitsu.prototype.platform.persist.mapper.abs.AbstractMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrgMapper extends AbstractMapper<Org> {

    List<Org> getAll(@Param("typeCode") String typeCode);

    Org findByUri(String uri);

}
