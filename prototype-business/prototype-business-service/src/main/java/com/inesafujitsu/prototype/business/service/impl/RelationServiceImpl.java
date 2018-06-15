package com.inesafujitsu.prototype.business.service.impl;

import com.inesafujitsu.prototype.business.model.Relation;
import com.inesafujitsu.prototype.business.persist.mapper.RelationMapper;
import com.inesafujitsu.prototype.business.service.RelationService;
import com.inesafujitsu.prototype.business.service.support.ORM;
import com.inesafujitsu.prototype.platform.commons.exception.EntityNotPersistedException;
import com.inesafujitsu.prototype.platform.commons.exception.EntityPersistedException;
import com.inesafujitsu.prototype.platform.commons.exception.ParameterInvalidException;
import com.inesafujitsu.prototype.platform.commons.support.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

public class RelationServiceImpl implements RelationService {

    @Autowired
    RelationMapper relationMapper;

    @Override
    public void bind(String xEntityName, String xId, String yEntityName, String yId) {
        if (!isParameterValid(xEntityName, xId, yEntityName, yId)) {
            throw new ParameterInvalidException(xEntityName, xId, yEntityName, yId);
        }

        String xTableName = ORM.lookup(xEntityName).getTableName();
        String yTableName = ORM.lookup(yEntityName).getTableName();

        if (hasBound(xTableName, xId, yTableName, yId) || hasBound(yTableName, yId, xTableName, xId)) {
            throw new EntityPersistedException(Relation.class.getTypeName(),
                    StringUtils.format("%s, %s, %s, %s", xEntityName, xId, yEntityName, yId));
        }

        relationMapper.insert(xTableName, xId, yTableName, yId);
    }

    @Override
    public void unbind(String xEntityName, String xId, String yEntityName, String yId) {
        if (!isParameterValid(xEntityName, xId, yEntityName, yId)) {
            throw new ParameterInvalidException(xEntityName, xId, yEntityName, yId);
        }

        String xTableName = ORM.lookup(xEntityName).getTableName();
        String yTableName = ORM.lookup(yEntityName).getTableName();

        if (!hasBound(xTableName, xId, yTableName, yId) && !hasBound(yTableName, yId, xTableName, xId)) {
            throw new EntityNotPersistedException(Relation.class.getTypeName(),
                    StringUtils.format("%s, %s, %s, %s", xEntityName, xId, yEntityName, yId));
        }

        relationMapper.delete(xTableName, xId, yTableName, yId);
        relationMapper.delete(yTableName, yId, xTableName, xId);
    }

    private boolean isParameterValid(String xEntityName, String xId, String yEntityName, String yId) {
        String xTableName = ORM.lookup(xEntityName) != null ? ORM.lookup(xEntityName).getTableName() : null;
        String yTableName = ORM.lookup(yEntityName) != null ? ORM.lookup(yEntityName).getTableName() : null;

        if (StringUtils.isBlank(xTableName) || StringUtils.isBlank(xId)
                || StringUtils.isBlank(yTableName) || StringUtils.isBlank(yId)) {
            return false;
        }

        return true;
    }

    private boolean hasBound(String xTableName, String xId, String yTableName, String yId) {
        return relationMapper.getOne(xTableName, xId, yTableName, yId) != null;
    }

}
