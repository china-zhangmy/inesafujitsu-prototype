package com.inesafujitsu.prototype.platform.persist.mapper;

import com.inesafujitsu.prototype.platform.model.Org;
import com.inesafujitsu.prototype.platform.persist.mapper.abs.AbstractMapper;

public interface OrgMapper extends AbstractMapper<Org> {

    Org findByUri(String uri);

}
