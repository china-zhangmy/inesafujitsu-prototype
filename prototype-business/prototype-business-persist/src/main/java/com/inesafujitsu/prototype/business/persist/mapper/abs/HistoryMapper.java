package com.inesafujitsu.prototype.business.persist.mapper.abs;

import com.inesafujitsu.prototype.business.model.abs.History;
import com.inesafujitsu.prototype.platform.persist.mapper.abs.AbstractMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface HistoryMapper<T extends History> extends AbstractMapper<T> {

    List<T> getAll(String masterId);

    T getOne(@Param("masterId") String masterId, @Param("idx") Integer idx);

}
