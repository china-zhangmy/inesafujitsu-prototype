package com.inesafujitsu.prototype.platform.service;

import com.inesafujitsu.prototype.platform.model.User;

import java.util.List;
import java.util.Map;

public interface UserService extends IService<User> {

    List<User> getAll(String orgUri, String groupId);

    User create(String orgUri, String groupId, Map<String, Object> args);

    User update(String orgUri, String groupId, String id, Map<String, Object> args);

    void batchUpdate(String sourceOrgUri, String groupId, String destOrgUri);

    void remove(String id);
}
