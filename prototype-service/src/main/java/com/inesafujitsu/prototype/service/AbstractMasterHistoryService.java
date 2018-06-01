package com.inesafujitsu.prototype.service;

import com.inesafujitsu.prototype.model.base.History;
import com.inesafujitsu.prototype.model.base.Master;
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

    boolean validateOperation(String operator);

    M updateMaster(String id, String operator, Map<String, Object> masterMap);
}
