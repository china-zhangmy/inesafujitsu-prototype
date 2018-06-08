package com.inesafujitsu.prototype.persist.mapper.abs;

import com.inesafujitsu.prototype.model.business.History;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface HistoryMapper<T extends History> extends AbstractMapper<T> {

    List<T> getAll(String masterId);

    T getOne(@Param("masterId") String masterId, @Param("idx") Integer idx);

}
