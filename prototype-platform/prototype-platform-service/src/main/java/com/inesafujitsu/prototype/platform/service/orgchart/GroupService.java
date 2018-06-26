package com.inesafujitsu.prototype.platform.service.orgchart;

import com.inesafujitsu.prototype.platform.model.orgchart.Group;
import com.inesafujitsu.prototype.platform.service.IService;

import java.util.List;
import java.util.Map;

public interface GroupService extends IService<Group> {

    List<Group> getAll(String orgUri);

    Group create(String orgUri, Map<String, Object> args);

    Group update(String orgUri, String id, Map<String, Object> args);

    void remove(String id);
}
