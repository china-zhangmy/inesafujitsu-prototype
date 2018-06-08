package com.inesafujitsu.prototype.service.impl;

import com.inesafujitsu.prototype.common.IdGenerator;
import com.inesafujitsu.prototype.model.business.History;
import com.inesafujitsu.prototype.model.business.Master;
import com.inesafujitsu.prototype.persist.mapper.abs.HistoryMapper;
import com.inesafujitsu.prototype.persist.mapper.abs.MasterMapper;
import com.inesafujitsu.prototype.service.AbstractMasterHistoryService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class DefaultMasterHistoryServiceImpl<M extends Master, H extends History>
        implements AbstractMasterHistoryService<M, H> {

    @Autowired
    protected MasterMapper<M> masterMapper;

    @Autowired
    protected HistoryMapper<H> historyMapper;

    public abstract M buildMaster(Map<String, Object> args);

    public abstract H buildHistory(Map<String, Object> args);

    @Override
    public List<M> getAllMasters() {
        return masterMapper.getAll();
    }

    @Override
    public M getMaster(String id) {
        return masterMapper.getOne(id);
    }

    @Override
    public List<H> getAllHistories(String masterId) {
        return historyMapper.getAll(masterId);
    }

    @Override
    public H getHistory(String masterId, Integer idx) {
        return historyMapper.getOne(masterId, idx);
    }

    @Override
    public M createMaster(Map<String, Object> args) {
        args = new HashMap<>(args);

        String id = IdGenerator.generateId();

        args.put("id", id);
        args.put("currIdx", 0);
        args.put("createDate", new Date());
        args.put("createUser", "dummy_create_user");

        M master = buildMaster(args);
        masterMapper.insert(master);

        createHistory(master);

        return getMaster(id);
    }

    @Override
    public H createHistory(M master) {
        Map args = new HashMap<>();

        String id = IdGenerator.generateId();

        args.put("id", id);
        args.put("master", master);
        args.put("idx", master.getCurrIdx());
        args.put("createDate", master.getUpdateDate() == null ? master.getCreateDate() : master.getUpdateDate());
        args.put("createUser", master.getUpdateDate() == null ? master.getCreateUser() : master.getUpdateUser());
        args.put("note", master.getUpdateDate() == null ? "Create" : "Update");

        H history = (H) buildHistory(args);

        historyMapper.insert(history);

        return historyMapper.getOne(id);
    }

    @Override
    public M checkOutMaster(String id) {
        masterMapper.lock(id, new Date(), "dummy_lock_user");
        return getMaster(id);
    }

    @Override
    public M checkInMaster(String id) {
        masterMapper.unlock(id);
        return getMaster(id);
    }

    @Override
    public M updateMaster(String id, Map<String, Object> masterMap) {
        if (masterMap == null) {
            // TODO
        }

        masterMap = new HashMap<>(masterMap);

        Master masterDb = getMaster(id);

        masterMap.put("id", id);
        masterMap.put("updateDate", new Date());
        masterMap.put("updateUser", "dummy_update_user");
        masterMap.put("currIdx", masterDb.getCurrIdx() + 1);

        M master = buildMaster(masterMap);
        masterMapper.update(master);

        createHistory(master);

        return getMaster(id);
    }

}
