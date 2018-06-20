package com.inesafujitsu.prototype.business.service;

import com.inesafujitsu.prototype.business.model.abs.Master;
import com.inesafujitsu.prototype.platform.service.IService;

import java.util.Map;

public interface MasterService<M extends Master> extends IService<M> {

    void create(String id, Map<String, Object> args);

    void update(String id, Map<String, Object> args);

    void remove(String id);

    void checkOut(String id);

    void checkIn(String id);
}
