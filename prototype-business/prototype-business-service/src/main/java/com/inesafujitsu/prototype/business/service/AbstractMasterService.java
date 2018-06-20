package com.inesafujitsu.prototype.business.service;

import com.inesafujitsu.prototype.business.model.abs.Master;
import com.inesafujitsu.prototype.business.persist.mapper.abs.MasterMapper;
import com.inesafujitsu.prototype.platform.persist.mapper.abs.AbstractMapper;
import com.inesafujitsu.prototype.platform.service.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public abstract class AbstractMasterService<M extends Master> extends AbstractService<M> implements MasterService<M> {

    @Autowired
    protected MasterMapper<M> masterMapper;

    @Override
    protected AbstractMapper<M> getMapper() {
        return masterMapper;
    }

    protected abstract M buildMaster(Map<String, Object> args);

    @Override
    public void create(String id, Map<String, Object> args) {
        args = new HashMap<>(args);

        args.put("id", id);
        args.put("currIdx", 0);
        args.put("createDate", new Date());
        args.put("createUser", "dummy_create_user");

        M master = buildMaster(args);
        insert(master);
    }

    @Override
    public void update(String id, Map<String, Object> args) {
        args = new HashMap<>(args);
        Master masterDb = getOne(id);

        args.put("id", id);
        args.put("updateDate", new Date());
        args.put("updateUser", "dummy_update_user");
        args.put("currIdx", masterDb.getCurrIdx() + 1);

        M master = buildMaster(args);
        update(master);
    }

    @Override
    public void remove(String id) {
        masterMapper.remove(id, new Date(), "dummy_delete_user");

        Map<String, Object> args = new HashMap<>();
        Master masterDb = getOne(id);
        args.put("id", id);
        args.put("currIdx", masterDb.getCurrIdx() + 1);

        M master = buildMaster(args);
        update(master);
    }

    @Override
    public void checkOut(String id) {
        masterMapper.lock(id, new Date(), "dummy_lock_user");
    }

    @Override
    public void checkIn(String id) {
        masterMapper.unlock(id);
    }

}
