package com.inesafujitsu.prototype.platform.service;

import com.inesafujitsu.prototype.platform.model.User;

import java.util.List;
import java.util.Map;

public interface UserService extends IService<User> {

    List<User> getAll(String orgUri);

    User create(String orgUri, Map<String, Object> userMap);

    User update(String orgUri, Map<String, Object> userMap);

    void remove(String id);
}
