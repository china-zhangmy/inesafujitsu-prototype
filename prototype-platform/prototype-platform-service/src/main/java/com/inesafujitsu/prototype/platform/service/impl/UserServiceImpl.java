package com.inesafujitsu.prototype.platform.service.impl;

import com.inesafujitsu.prototype.platform.commons.exception.EntityNotPersistedException;
import com.inesafujitsu.prototype.platform.commons.support.IdGenerator;
import com.inesafujitsu.prototype.platform.commons.support.StringUtils;
import com.inesafujitsu.prototype.platform.model.User;
import com.inesafujitsu.prototype.platform.persist.mapper.OrgMapper;
import com.inesafujitsu.prototype.platform.persist.mapper.UserMapper;
import com.inesafujitsu.prototype.platform.persist.mapper.abs.AbstractMapper;
import com.inesafujitsu.prototype.platform.service.AbstractService;
import com.inesafujitsu.prototype.platform.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
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
    public List<User> getAll(String orgUri, User.Type userType, String groupId) {
        return userMapper.getAll(orgUri, userType, groupId);
    }

    @Override
    public User createUser(String orgUri, String groupId, Map<String, Object> args) {
        if (StringUtils.isBlank(orgUri) || orgMapper.findByUri(orgUri) == null) {
            throw new RuntimeException("A user should be created under a given organization node!");
        }

        User group = getOne(groupId);
        if (StringUtils.isNotBlank(groupId) && (group == null || !User.Type.GROUP.equals(group.getType()))) {
            throw new EntityNotPersistedException("Group", groupId);
        }

        String id = IdGenerator.generateId();

        args = new HashMap<>(args);
        args.put("id", id);
        args.put("type", User.Type.USER);
        args.put("org", orgMapper.findByUri(orgUri));
        args.put("group", group);
        User user = new User.Builder(args).build();

        insert(user);

        return getOne(id);
    }

    @Override
    public User createGroup(String orgUri, Map<String, Object> args) {
        if (StringUtils.isBlank(orgUri) || orgMapper.findByUri(orgUri) == null) {
            throw new RuntimeException("A user should be created under a given organization node!");
        }

        String id = IdGenerator.generateId();

        args = new HashMap<>(args);
        args.put("id", id);
        args.put("type", User.Type.GROUP);
        args.put("org", orgMapper.findByUri(orgUri));
        User group = new User.Builder(args).build();

        insert(group);

        return getOne(id);
    }

    @Override
    public User update(String id, Map<String, Object> args) {
        args = new HashMap<>(args);
        args.put("id", id);
        User user = new User.Builder(args).build();

        update(user);

        return getOne(user.getId());
    }

    @Override
    public void remove(String id) {
        delete(id);
    }

}
