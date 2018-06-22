package com.inesafujitsu.prototype.platform.service;

import com.inesafujitsu.prototype.platform.model.User;

import java.util.List;
import java.util.Map;

public interface UserService extends IService<User> {

    List<User> getAll(String orgUri, User.Type userType, String groupId);

    User createUser(String orgUri, String groupId, Map<String, Object> args);

    User createGroup(String orgUri, Map<String, Object> args);

    User update(String id, Map<String, Object> args);

    void remove(String id);
}
