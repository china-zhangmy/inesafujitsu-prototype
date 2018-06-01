package com.inesafujitsu.prototype.persist.mapper;

import com.inesafujitsu.prototype.model.base.Master;

public interface MasterMapper<T extends Master> extends AbstractMapper<T>, LockMapper {


}
