package com.inesafujitsu.prototype.platform.service.orgchart.impl;

import com.inesafujitsu.prototype.platform.commons.exception.EntityNotPersistedException;
import com.inesafujitsu.prototype.platform.commons.exception.EntityPersistedException;
import com.inesafujitsu.prototype.platform.commons.exception.EntityRemoveNotAllowedException;
import com.inesafujitsu.prototype.platform.commons.support.IdGenerator;
import com.inesafujitsu.prototype.platform.commons.support.StringUtils;
import com.inesafujitsu.prototype.platform.model.orgchart.Org;
import com.inesafujitsu.prototype.platform.persist.mapper.abs.AbstractMapper;
import com.inesafujitsu.prototype.platform.persist.mapper.orgchart.OrgMapper;
import com.inesafujitsu.prototype.platform.persist.mapper.orgchart.OrgTypeMapper;
import com.inesafujitsu.prototype.platform.service.AbstractService;
import com.inesafujitsu.prototype.platform.service.orgchart.OrgService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

public class OrgServiceImpl extends AbstractService<Org> implements OrgService {

    @Autowired
    private OrgMapper orgMapper;

    @Autowired
    private OrgTypeMapper orgTypeMapper;

    @Override
    protected AbstractMapper<Org> getMapper() {
        return orgMapper;
    }

    @Override
    public List<Org> getAll() {
        Org.Type topOrgType = orgTypeMapper.getTop();
        return orgMapper.getAll(topOrgType != null ? topOrgType.getCode() : "C");
    }

    @Override
    public Org findByUri(String uri) {
        return orgMapper.findByUri(uri);
    }

    @Override
    public Org createCompany(Map<String, Object> nodeMap) {
        String companyId = IdGenerator.generateId();

        nodeMap.put("id", companyId);
        Org.Type topOrgType = orgTypeMapper.getTop();
        nodeMap.put("typeCode", topOrgType != null ? topOrgType.getCode() : "C");

        Org company = new Org.Builder(nodeMap).build();

        insert(company);

        return getOne(companyId);
    }

    @Override
    public Org addChild(String nodeUri, Map<String, Object> childNodeMap) {
        if (StringUtils.isBlank(nodeUri)) {
            throw new EntityNotPersistedException(Org.class.getTypeName(), "parent");
        }

        if (StringUtils.isNotBlank((String) childNodeMap.get("uri"))) {
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

        if (node == null) {
            throw new EntityNotPersistedException(Org.class.getTypeName(), nodeUri);
        }

        node = new Org.Builder(nodeMap).build();

        update(node);

        return getOne(node.getId());
    }

    @Override
    public List<Org.Type> getSubTypes(String typeCode) {
        Org.Type currNodeType = orgTypeMapper.getOne(typeCode);
        return currNodeType.getChildren();
    }

}
