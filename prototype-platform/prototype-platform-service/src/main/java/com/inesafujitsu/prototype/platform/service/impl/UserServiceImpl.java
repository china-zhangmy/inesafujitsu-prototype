package com.inesafujitsu.prototype.platform.service.impl;

import com.inesafujitsu.prototype.platform.commons.exception.EntityNotPersistedException;
import com.inesafujitsu.prototype.platform.commons.support.IdGenerator;
import com.inesafujitsu.prototype.platform.commons.support.StringUtils;
import com.inesafujitsu.prototype.platform.model.Org;
import com.inesafujitsu.prototype.platform.model.User;
import com.inesafujitsu.prototype.platform.model.UserGroup;
import com.inesafujitsu.prototype.platform.persist.mapper.OrgMapper;
import com.inesafujitsu.prototype.platform.persist.mapper.UserMapper;
import com.inesafujitsu.prototype.platform.persist.mapper.abs.AbstractMapper;
import com.inesafujitsu.prototype.platform.service.AbstractService;
import com.inesafujitsu.prototype.platform.service.UserGroupService;
import com.inesafujitsu.prototype.platform.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserServiceImpl extends AbstractService<User> implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private OrgMapper orgMapper;

    @Autowired
    private UserGroupService userGroupService;

    @Override
    protected AbstractMapper<User> getMapper() {
        return userMapper;
    }

    @Override
    public List<User> getAll(String orgUri, String groupId) {
        return userMapper.getAll(orgUri, groupId);
    }

    @Override
    public User create(String orgUri, String groupId, Map<String, Object> args) {
        String id = IdGenerator.generateId();

        args = extractAndValidate(orgUri, groupId, args);
        args.put("id", id);
        User user = new User.Builder(args).build();

        insert(user);

        return getOne(id);
    }

    @Override
    public User update(String orgUri, String groupId, String id, Map<String, Object> args) {
        args = extractAndValidate(orgUri, groupId, args);
        args.put("id", id);
        User user = new User.Builder(args).build();

        update(user);

        return getOne(id);
    }

    @Override
    public void batchUpdate(String sourceOrgUri, String groupId, String destOrgUri) {
        extractAndValidate(destOrgUri, groupId, Collections.emptyMap());
        userMapper.batchUpdate(sourceOrgUri, groupId, destOrgUri);
    }

    @Override
    public void remove(String id) {
        delete(id);
    }

    private Map<String, Object> extractAndValidate(String orgUri, String groupId, Map<String, Object> args) {
        Org org = orgMapper.findByUri(orgUri);
        if (StringUtils.isBlank(orgUri)) {
            throw new RuntimeException("A user should be created/updated under a given organization node!");
        } else if (org == null) {
            throw new EntityNotPersistedException("Organization", orgUri);
        }

        UserGroup group = userGroupService.getOne(groupId);
        if (StringUtils.isNotBlank(groupId) && group == null) {
            throw new EntityNotPersistedException("Group", groupId);
        }

        String superiorId = (String) args.get("superiorId");
        User superior = getOne(superiorId);
        if (StringUtils.isNotBlank(superiorId) && superior == null) {
            throw new EntityNotPersistedException("Superior", superiorId);
        }

        Map<String, Object> retArgs = new HashMap<>(args);
        retArgs.put("org", org);
        retArgs.put("group", group);
        retArgs.put("superior", superior);

        return retArgs;
    }

}
