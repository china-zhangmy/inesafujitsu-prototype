package com.inesafujitsu.prototype.platform.persist.mapper;

import com.inesafujitsu.prototype.platform.model.UserGroup;
import com.inesafujitsu.prototype.platform.persist.mapper.abs.AbstractMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserGroupMapper extends AbstractMapper<UserGroup> {

    List<UserGroup> getAll(@Param("orgUri") String orgUri);

}
