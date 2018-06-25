package com.inesafujitsu.prototype.platform.service.impl;

import com.inesafujitsu.prototype.platform.commons.exception.EntityNotPersistedException;
import com.inesafujitsu.prototype.platform.commons.support.IdGenerator;
import com.inesafujitsu.prototype.platform.commons.support.StringUtils;
import com.inesafujitsu.prototype.platform.model.Org;
import com.inesafujitsu.prototype.platform.model.UserGroup;
import com.inesafujitsu.prototype.platform.persist.mapper.OrgMapper;
import com.inesafujitsu.prototype.platform.persist.mapper.UserGroupMapper;
import com.inesafujitsu.prototype.platform.persist.mapper.abs.AbstractMapper;
import com.inesafujitsu.prototype.platform.service.AbstractService;
import com.inesafujitsu.prototype.platform.service.UserGroupService;
import com.inesafujitsu.prototype.platform.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserGroupServiceImpl extends AbstractService<UserGroup> implements UserGroupService {

    @Autowired
    private UserGroupMapper userGroupMapper;

    @Autowired
    private OrgMapper orgMapper;

    @Autowired
    private UserService userService;

    @Override
    protected AbstractMapper<UserGroup> getMapper() {
        return userGroupMapper;
    }

    @Override
    public List<UserGroup> getAll(String orgUri) {
        return userGroupMapper.getAll(orgUri);
    }

    @Override
    public UserGroup create(String orgUri, Map<String, Object> args) {
        String id = IdGenerator.generateId();

        args = extractAndValidate(orgUri, args);
        args.put("id", id);
        UserGroup userGroup = new UserGroup.Builder(args).build();

        insert(userGroup);

        return getOne(id);
    }

    @Override
    public UserGroup update(String orgUri, String id, Map<String, Object> args) {
        args = extractAndValidate(orgUri, args);
        args.put("id", id);
        UserGroup userGroup = new UserGroup.Builder(args).build();
        UserGroup sourceUserGroup = getOne(id);
        String sourceOrgUri = sourceUserGroup.getOrg().getUri();

        update(userGroup);

        if (!orgUri.equals(sourceOrgUri)) {
            batchMoveCascade(sourceOrgUri, id, orgUri);
        }

        return getOne(id);
    }

    private void batchMoveCascade(String sourceOrgUri, String groupId, String destOrgUri) {
        userService.batchUpdate(sourceOrgUri, groupId, destOrgUri);
    }

    @Override
    public void remove(String id) {
        delete(id);
    }

    private Map<String, Object> extractAndValidate(String orgUri, Map<String, Object> args) {
        Org org = orgMapper.findByUri(orgUri);
        if (StringUtils.isBlank(orgUri)) {
            throw new RuntimeException("A user should be created/updated under a given organization node!");
        } else if (org == null) {
            throw new EntityNotPersistedException("Organization", orgUri);
        }

        Map<String, Object> retArgs = new HashMap<>(args);
        retArgs.put("org", org);

        return retArgs;
    }

}
