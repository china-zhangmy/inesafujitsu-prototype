package com.inesafujitsu.prototype.platform.service;

import com.inesafujitsu.prototype.platform.model.Org;

import java.util.List;
import java.util.Map;

public interface OrgService extends IService<Org> {

    Org findByUri(String uri);

    Org createCompany(Map<String, Object> nodeMap);

    Org addChild(String nodeUri, Map<String, Object> childNodeMap);

    Org remove(String nodeUri);

    Org update(String nodeUri, Map<String, Object> nodeMap);

    List<Org.Type> getSubTypes(String typeCode);
}
