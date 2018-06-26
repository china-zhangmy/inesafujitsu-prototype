package com.inesafujitsu.prototype.platform.service.orgchart;

import com.inesafujitsu.prototype.platform.model.orgchart.User;
import com.inesafujitsu.prototype.platform.service.IService;

import java.util.List;
import java.util.Map;

public interface UserService extends IService<User> {

    List<User> getAll(String orgUri, String groupId);

    User create(String orgUri, String groupId, Map<String, Object> args);

    User update(String orgUri, String groupId, String id, Map<String, Object> args);

    void batchUpdate(String sourceOrgUri, String groupId, String destOrgUri);

    void remove(String id);
}
