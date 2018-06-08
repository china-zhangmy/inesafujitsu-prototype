package com.inesafujitsu.prototype.service;

import com.inesafujitsu.prototype.model.business.History;
import com.inesafujitsu.prototype.model.business.Master;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Transactional
public interface AbstractMasterHistoryService<M extends Master, H extends History> {

    List<M> getAllMasters();

    M getMaster(String id);

    M createMaster(Map<String, Object> args);

    List<H> getAllHistories(String masterId);

    H getHistory(String masterId, Integer idx);

    H createHistory(M master);

    M checkOutMaster(String id);

    M checkInMaster(String id);

    M updateMaster(String id, Map<String, Object> masterMap);

}
