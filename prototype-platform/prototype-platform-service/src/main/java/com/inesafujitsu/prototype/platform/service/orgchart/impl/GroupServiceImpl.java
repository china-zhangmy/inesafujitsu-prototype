package com.inesafujitsu.prototype.platform.service.orgchart.impl;

import com.inesafujitsu.prototype.platform.commons.exception.EntityNotPersistedException;
import com.inesafujitsu.prototype.platform.commons.support.IdGenerator;
import com.inesafujitsu.prototype.platform.commons.support.StringUtils;
import com.inesafujitsu.prototype.platform.model.orgchart.Group;
import com.inesafujitsu.prototype.platform.model.orgchart.Org;
import com.inesafujitsu.prototype.platform.persist.mapper.abs.AbstractMapper;
import com.inesafujitsu.prototype.platform.persist.mapper.orgchart.GroupMapper;
import com.inesafujitsu.prototype.platform.persist.mapper.orgchart.OrgMapper;
import com.inesafujitsu.prototype.platform.service.AbstractService;
import com.inesafujitsu.prototype.platform.service.orgchart.GroupService;
import com.inesafujitsu.prototype.platform.service.orgchart.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupServiceImpl extends AbstractService<Group> implements GroupService {

    @Autowired
    private GroupMapper groupMapper;

    @Autowired
    private OrgMapper orgMapper;

    @Autowired
    private UserService userService;

    @Override
    protected AbstractMapper<Group> getMapper() {
        return groupMapper;
    }

    @Override
    public List<Group> getAll(String orgUri) {
        return groupMapper.getAll(orgUri);
    }

    @Override
    public Group create(String orgUri, Map<String, Object> args) {
        String id = IdGenerator.generateId();

        args = extractAndValidate(orgUri, args);
        args.put("id", id);
        Group group = new Group.Builder(args).build();

        insert(group);

        return getOne(id);
    }

    @Override
    public Group update(String orgUri, String id, Map<String, Object> args) {
        args = extractAndValidate(orgUri, args);
        args.put("id", id);
        Group group = new Group.Builder(args).build();
        Group sourceGroup = getOne(id);
        String sourceOrgUri = sourceGroup.getOrg().getUri();

        update(group);

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
