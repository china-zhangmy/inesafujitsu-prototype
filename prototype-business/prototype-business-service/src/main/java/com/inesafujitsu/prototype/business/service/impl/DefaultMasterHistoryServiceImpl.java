package com.inesafujitsu.prototype.business.service.impl;

import com.inesafujitsu.prototype.business.model.abs.History;
import com.inesafujitsu.prototype.business.model.abs.Master;
import com.inesafujitsu.prototype.business.service.HistoryService;
import com.inesafujitsu.prototype.business.service.MasterHistoryService;
import com.inesafujitsu.prototype.business.service.MasterService;
import com.inesafujitsu.prototype.platform.commons.support.IdGenerator;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DefaultMasterHistoryServiceImpl<M extends Master, H extends History>
        implements MasterHistoryService<M, H> {

    private MasterService<M> masterService;

    private HistoryService<H> historyService;

    public DefaultMasterHistoryServiceImpl(MasterService<M> masterService, HistoryService<H> historyService) {
        this.masterService = masterService;
        this.historyService = historyService;
    }

    @Override
    public List<M> getAllMasters() {
        return masterService.getAll();
    }

    @Override
    public M getMaster(String id) {
        return masterService.getOne(id);
    }

    @Override
    public List<H> getAllHistories(String masterId) {
        return historyService.getAll(masterId);
    }

    @Override
    public H getHistory(String masterId, Integer idx) {
        return historyService.getOne(masterId, idx);
    }

    @Override
    public M create(Map<String, Object> masterMap) {
        masterMap = new HashMap<>(masterMap);

        String id = IdGenerator.generateId();
        masterService.create(id, masterMap);

        M master = getMaster(id);
        historyService.create(master, master.getCreateDate(), master.getCreateUser(), "Create");

        return master;
    }

    @Override
    public M update(String id, Map<String, Object> masterMap) {
        masterService.update(id, masterMap);

        M master = getMaster(id);
        historyService.create(master, master.getUpdateDate(), master.getUpdateUser(), "Update");

        return master;
    }

    @Override
    public void remove(String id) {
        masterService.remove(id);

        M master = getMaster(id);
        historyService.create(master, master.getDeleteDate(), master.getDeleteUser(), "Delete");
    }


    @Override
    public M checkOut(String id) {
        masterService.checkOut(id);
        return getMaster(id);
    }

    @Override
    public M checkIn(String id) {
        masterService.checkIn(id);
        return getMaster(id);
    }

}
