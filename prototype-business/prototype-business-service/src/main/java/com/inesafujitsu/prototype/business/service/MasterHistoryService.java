package com.inesafujitsu.prototype.business.service;

import com.inesafujitsu.prototype.business.model.abs.History;
import com.inesafujitsu.prototype.business.model.abs.Master;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Transactional
public interface MasterHistoryService<M extends Master, H extends History> {

    List<M> getAllMasters();

    M getMaster(String id);

    List<H> getAllHistories(String masterId);

    H getHistory(String masterId, Integer idx);

    M create(Map<String, Object> masterMap);

    M update(String id, Map<String, Object> masterMap);

    void remove(String id);

    M checkOut(String id);

    M checkIn(String id);

}
