package com.inesafujitsu.prototype.platform.service.ctrl;

import com.inesafujitsu.prototype.platform.model.ctrl.Privilege;
import com.inesafujitsu.prototype.platform.service.IService;

import java.util.List;
import java.util.Map;

public interface PrivilegeService extends IService<Privilege> {

    List<Privilege> getAll(String typeCode);

    Privilege createOrUpdate(String code, Map<String, Object> args);

    void remove(String code);
}
