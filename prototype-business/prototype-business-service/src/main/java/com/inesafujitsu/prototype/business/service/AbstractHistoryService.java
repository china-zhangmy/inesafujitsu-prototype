package com.inesafujitsu.prototype.business.service;

import com.inesafujitsu.prototype.business.model.abs.History;
import com.inesafujitsu.prototype.business.model.abs.Master;
import com.inesafujitsu.prototype.business.persist.mapper.abs.HistoryMapper;
import com.inesafujitsu.prototype.platform.commons.support.IdGenerator;
import com.inesafujitsu.prototype.platform.persist.mapper.abs.AbstractMapper;
import com.inesafujitsu.prototype.platform.service.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class AbstractHistoryService<H extends History> extends AbstractService<H> implements HistoryService<H> {

    @Autowired
    protected HistoryMapper<H> historyMapper;

    @Override
    protected AbstractMapper<H> getMapper() {
        return historyMapper;
    }

    public abstract H buildHistory(Map<String, Object> args);

    @Override
    public List<H> getAll(String masterId) {
        return historyMapper.getAll(masterId);
    }

    @Override
    public H getOne(String masterId, Integer idx) {
        return historyMapper.getOne(masterId, idx);
    }

    @Override
    public void create(Master master, Date createDate, String createUser, String note) {
        Map args = new HashMap<>();

        String id = IdGenerator.generateId();

        args.put("id", id);
        args.put("master", master);
        args.put("idx", master.getCurrIdx());
        args.put("createDate", createDate);
        args.put("createUser", createUser);
        args.put("note", note);

        H history = (H) buildHistory(args);

        insert(history);
    }
}
