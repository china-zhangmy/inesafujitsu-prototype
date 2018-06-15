package com.inesafujitsu.prototype.business.service;

import com.inesafujitsu.prototype.business.model.abs.History;
import com.inesafujitsu.prototype.business.model.abs.Master;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Transactional
public interface AbstractMasterHistoryService<M extends Master, H extends History> {

    List<M> getAllMasters();

    M getMaster(String id);

    M createMaster(Map<String, Object> masterMap);

    List<H> getAllHistories(String masterId);

    H getHistory(String masterId, Integer idx);

    M checkOutMaster(String id);

    M checkInMaster(String id);

    M updateMaster(String id, Map<String, Object> masterMap);

    void removeMaster(String id);

}
