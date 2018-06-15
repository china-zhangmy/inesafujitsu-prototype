package com.inesafujitsu.prototype.platform.service.impl;

import com.inesafujitsu.prototype.platform.commons.exception.EntityNotPersistedException;
import com.inesafujitsu.prototype.platform.commons.exception.EntityPersistedException;
import com.inesafujitsu.prototype.platform.commons.exception.EntityRemoveNotAllowedException;
import com.inesafujitsu.prototype.platform.commons.support.IdGenerator;
import com.inesafujitsu.prototype.platform.model.Org;
import com.inesafujitsu.prototype.platform.model.OrgType;
import com.inesafujitsu.prototype.platform.persist.mapper.OrgMapper;
import com.inesafujitsu.prototype.platform.service.OrgService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

public class OrgServiceImpl implements OrgService {

    @Autowired
    OrgMapper orgMapper;

    @Override
    public Org findByUri(String uri) {
        return orgMapper.findByUri(uri);
    }

    @Override
    public Org createCompany(Map<String, Object> nodeMap) {
        if (nodeMap.get("id") != null) {
            throw new EntityPersistedException(Org.class.getTypeName(), String.valueOf(nodeMap.get("id")));
        }

        String companyId = IdGenerator.generateId();

        nodeMap.put("id", companyId);
        nodeMap.put("typeCode", OrgType.COMPANY.getCode());

        Org company = new Org.Builder(nodeMap).build();

        insert(company);

        return getOne(companyId);
    }

    @Override
    public Org addChild(String nodeUri, Map<String, Object> childNodeMap) {
        if (nodeUri == null) {
            throw new EntityNotPersistedException(Org.class.getTypeName(), "parent");
        }

        if (childNodeMap.get("uri") != null) {
            throw new EntityPersistedException(Org.class.getTypeName(), String.valueOf(childNodeMap.get("uri")));
        }

        String childNodeId = IdGenerator.generateId();
        Org currNode = findByUri(nodeUri);

        childNodeMap.put("id", childNodeId);
        childNodeMap.put("parent", currNode);

        Org childNode = new Org.Builder(childNodeMap).build();

        insert(childNode);

        return getOne(childNodeId);
    }

    @Override
    public Org remove(String nodeUri) {
        Org currNode = findByUri(nodeUri);
        Org parentNode = currNode.getParent();
        List<Org> childNodes = currNode.getChildren();

        if (childNodes != null && childNodes.size() > 0) {
            throw new EntityRemoveNotAllowedException(Org.class.getTypeName(), currNode.getUri());
        }

        delete(nodeUri);

        return parentNode;
    }

    @Override
    public Org update(String nodeUri, Map<String, Object> nodeMap) {
        Org node = findByUri(nodeUri);

        if (node.getId() == null) {
            throw new EntityNotPersistedException(Org.class.getTypeName(), node.getName());
        }

        update(node);

        return getOne(node.getId());
    }

    @Override
    public List<Org> getAll() {
        return orgMapper.getAll();
    }

    @Override
    public Org getOne(String id) {
        return orgMapper.getOne(id);
    }

    @Override
    public void insert(Org entity) {
        orgMapper.insert(entity);
    }

    @Override
    public void update(Org entity) {
        orgMapper.update(entity);
    }

    @Override
    public void delete(String id) {
        orgMapper.delete(id);
    }

}
