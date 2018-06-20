package com.inesafujitsu.prototype.platform.service.impl;

import com.inesafujitsu.prototype.platform.commons.support.IdGenerator;
import com.inesafujitsu.prototype.platform.commons.support.StringUtils;
import com.inesafujitsu.prototype.platform.model.User;
import com.inesafujitsu.prototype.platform.persist.mapper.OrgMapper;
import com.inesafujitsu.prototype.platform.persist.mapper.UserMapper;
import com.inesafujitsu.prototype.platform.persist.mapper.abs.AbstractMapper;
import com.inesafujitsu.prototype.platform.service.AbstractService;
import com.inesafujitsu.prototype.platform.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

public class UserServiceImpl extends AbstractService<User> implements UserService {

    @Autowired
    UserMapper userMapper;

    @Autowired
    OrgMapper orgMapper;

    @Override
    protected AbstractMapper<User> getMapper() {
        return userMapper;
    }

    @Override
    public List<User> getAll(String orgUri) {
        return userMapper.getAll(orgUri);
    }

    @Override
    public User create(String orgUri, Map<String, Object> userMap) {
        if (StringUtils.isBlank(orgUri) || orgMapper.findByUri(orgUri) == null) {
            throw new RuntimeException("A user should be created under a given organization node!");
        }

        String userId = IdGenerator.generateId();

        userMap.put("id", userId);
        userMap.put("org", orgMapper.findByUri(orgUri));

        User user = new User.Builder(userMap).build();

        insert(user);

        return getOne(userId);
    }

    @Override
    public User update(String orgUri, Map<String, Object> userMap) {
        if (StringUtils.isBlank(orgUri) || orgMapper.findByUri(orgUri) == null) {
            throw new RuntimeException("A user should be updated under a given organization node!");
        }

        User user = new User.Builder(userMap).build();

        update(user);

        return getOne(user.getId());
    }

    @Override
    public void remove(String id) {
        delete(id);
    }

}
