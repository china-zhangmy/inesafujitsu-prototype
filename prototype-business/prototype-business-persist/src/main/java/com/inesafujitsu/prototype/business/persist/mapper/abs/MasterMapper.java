package com.inesafujitsu.prototype.business.persist.mapper.abs;

import com.inesafujitsu.prototype.business.model.abs.Master;
import com.inesafujitsu.prototype.platform.persist.mapper.abs.AbstractMapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;

public interface MasterMapper<T extends Master> extends AbstractMapper<T> {

    void lock(@Param("id") String id, @Param("lockDate") Date lockDate, @Param("lockUser") String lockUser);

    void unlock(String id);

    void remove(@Param("id") String id, @Param("deleteDate") Date deleteDate, @Param("deleteUser") String deleteUser);

}
