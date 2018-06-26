package com.inesafujitsu.prototype.platform.persist.mapper.orgchart;

import com.inesafujitsu.prototype.platform.model.orgchart.Org;
import com.inesafujitsu.prototype.platform.persist.mapper.abs.AbstractMapper;

public interface OrgTypeMapper extends AbstractMapper<Org.Type> {

    @Override
    Org.Type getOne(String code);

    Org.Type getTop();

}
