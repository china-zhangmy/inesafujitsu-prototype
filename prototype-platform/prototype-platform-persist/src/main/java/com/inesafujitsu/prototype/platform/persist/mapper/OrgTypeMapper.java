package com.inesafujitsu.prototype.platform.persist.mapper;

import com.inesafujitsu.prototype.platform.model.OrgType;
import com.inesafujitsu.prototype.platform.persist.mapper.abs.AbstractMapper;

public interface OrgTypeMapper extends AbstractMapper<OrgType> {

    @Override
    OrgType getOne(String code);

    OrgType getTop();

}
