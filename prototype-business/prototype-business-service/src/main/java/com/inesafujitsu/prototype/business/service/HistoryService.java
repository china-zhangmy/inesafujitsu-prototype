package com.inesafujitsu.prototype.business.service;

import com.inesafujitsu.prototype.business.model.abs.History;
import com.inesafujitsu.prototype.business.model.abs.Master;
import com.inesafujitsu.prototype.platform.service.IService;

import java.util.Date;
import java.util.List;

public interface HistoryService<H extends History> extends IService<H> {

    List<H> getAll(String masterId);

    H getOne(String masterId, Integer idx);

    void create(Master master, Date createDate, String createUser, String note);
}
