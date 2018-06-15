package com.inesafujitsu.prototype.business.service.impl;

import com.inesafujitsu.prototype.business.model.abs.History;
import com.inesafujitsu.prototype.business.model.abs.Master;
import com.inesafujitsu.prototype.business.persist.mapper.abs.HistoryMapper;
import com.inesafujitsu.prototype.business.persist.mapper.abs.MasterMapper;
import com.inesafujitsu.prototype.business.service.AbstractMasterHistoryService;
import com.inesafujitsu.prototype.platform.commons.support.IdGenerator;
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
    public M createMaster(Map<String, Object> masterMap) {
        masterMap = new HashMap<>(masterMap);

        String id = IdGenerator.generateId();
        Date createDate = new Date();
        String createUser = "dummy_create_user";

        masterMap.put("id", id);
        masterMap.put("currIdx", 0);
        masterMap.put("createDate", new Date());
        masterMap.put("createUser", "dummy_create_user");

        M master = buildMaster(masterMap);
        masterMapper.insert(master);

        createHistory(getMaster(id), createDate, createUser, "Create");

        return getMaster(id);
    }

    public void createHistory(M master, Date createDate, String createUser, String note) {
        Map args = new HashMap<>();

        String id = IdGenerator.generateId();

        args.put("id", id);
        args.put("master", master);
        args.put("idx", master.getCurrIdx());
        args.put("createDate", createDate);
        args.put("createUser", createUser);
        args.put("note", note);

        H history = (H) buildHistory(args);

        historyMapper.insert(history);
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
        masterMap = new HashMap<>(masterMap);

        Master masterDb = getMaster(id);
        Date updateDate = new Date();
        String updateUser = "dummy_update_user";

        masterMap.put("id", id);
        masterMap.put("updateDate", updateDate);
        masterMap.put("updateUser", updateUser);
        masterMap.put("currIdx", masterDb.getCurrIdx() + 1);

        M master = buildMaster(masterMap);
        masterMapper.update(master);

        createHistory(getMaster(id), updateDate, updateUser, "Update");

        return getMaster(id);
    }

    @Override
    public void removeMaster(String id) {
        Map<String, Object> masterMap = new HashMap<>();

        Master masterDb = getMaster(id);
        Date deleteDate = new Date();
        String deleteUser = "dummy_delete_user";

        masterMap.put("id", id);
        masterMap.put("currIdx", masterDb.getCurrIdx() + 1);

        M master = buildMaster(masterMap);

        masterMapper.remove(id, deleteDate, deleteUser);
        masterMapper.update(master);

        createHistory(getMaster(id), deleteDate, deleteUser, "Delete");
    }

}
