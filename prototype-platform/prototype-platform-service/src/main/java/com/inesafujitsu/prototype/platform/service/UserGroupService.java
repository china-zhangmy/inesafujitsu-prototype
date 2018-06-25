package com.inesafujitsu.prototype.platform.service;

import com.inesafujitsu.prototype.platform.model.UserGroup;

import java.util.List;
import java.util.Map;

public interface UserGroupService extends IService<UserGroup> {

    List<UserGroup> getAll(String orgUri);

    UserGroup create(String orgUri, Map<String, Object> args);

    UserGroup update(String orgUri, String id, Map<String, Object> args);

    void remove(String id);
}
