package com.inesafujitsu.prototype.persist.mapper.abs;

import org.apache.ibatis.annotations.Param;

import java.util.Date;

public interface LockMapper {

    void lock(@Param("id") String id, @Param("lockDate") Date lockDate, @Param("lockUser") String lockUser);

    void unlock(String id);

}
