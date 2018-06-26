package com.inesafujitsu.prototype.platform.service.ctrl.impl;

import com.inesafujitsu.prototype.platform.commons.exception.EntityNotPersistedException;
import com.inesafujitsu.prototype.platform.commons.support.StringUtils;
import com.inesafujitsu.prototype.platform.model.ctrl.Privilege;
import com.inesafujitsu.prototype.platform.persist.mapper.abs.AbstractMapper;
import com.inesafujitsu.prototype.platform.persist.mapper.ctrl.PrivilegeMapper;
import com.inesafujitsu.prototype.platform.service.AbstractService;
import com.inesafujitsu.prototype.platform.service.ctrl.PrivilegeService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

public class PrivilegeServiceImpl extends AbstractService<Privilege> implements PrivilegeService {

    @Autowired
    PrivilegeMapper privilegeMapper;

    @Override
    protected AbstractMapper<Privilege> getMapper() {
        return privilegeMapper;
    }

    @Override
    public List<Privilege> getAll(String typeCode) {
        return privilegeMapper.getAll(Privilege.Type.get(String.valueOf(typeCode)));
    }

    @Override
    public Privilege createOrUpdate(String code, Map<String, Object> args) {
        if (privilegeMapper.getOne(code) == null) {
            create(code, args);
        } else {
            update(code, args);
        }

        return privilegeMapper.getOne(code);
    }

    @Override
    public void remove(String code) {
        delete(code);
    }

    private void create(String code, Map<String, Object> args) {
        Privilege privilege = extractAndValidate(code, args);
        insert(privilege);
    }

    private void update(String code, Map<String, Object> args) {
        Privilege privilege = extractAndValidate(code, args);
        update(privilege);
    }

    private Privilege extractAndValidate(String code, Map<String, Object> args) {
        args = new HashMap<>(args);
        args.put("code", code);
        args.put("type", Privilege.Type.PRIVILEGE_GROUP);
        args.put("compositeCodes", extractAndValidateCompositeCodes(args));

        return new Privilege.Builder(args).build();
    }

    private String extractAndValidateCompositeCodes(Map<String, Object> args) {
        String compositeCodes = null;

        if (args.get("composite") instanceof List
                && ((List) args.get("composite")).size() > 0
                && ((List) args.get("composite")).get(0) instanceof Map) {
            List<Map<String, Object>> composite = (List<Map<String, Object>>) args.get("composite");

            Set<String> compositeCodeSet = new HashSet<>();
            composite.stream().forEach(privilegeMap -> {
                String compositeCode = String.valueOf(privilegeMap.get("code"));

                if (StringUtils.isNotBlank(compositeCode) && getOne(compositeCode) == null) {
                    throw new EntityNotPersistedException("Privilege", compositeCode);
                }

                compositeCodeSet.add(compositeCode);
            });

            compositeCodes = "," + StringUtils.join(compositeCodeSet, ",") + ",";
        }

        return compositeCodes;
    }
}
