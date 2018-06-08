package com.inesafujitsu.prototype.service.impl;

import com.inesafujitsu.prototype.persist.mapper.RelationMapper;
import com.inesafujitsu.prototype.service.RelationService;
import com.inesafujitsu.prototype.service.exception.ParameterMissingException;
import com.inesafujitsu.prototype.service.exception.RelationExistedException;
import com.inesafujitsu.prototype.service.exception.RelationNotExistedException;
import com.inesafujitsu.prototype.service.support.ORM;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

public class RelationServiceImpl implements RelationService {

    @Autowired
    RelationMapper relationMapper;

    @Override
    public void bind(String xEntityName, String xId, String yEntityName, String yId) {
        if (!isParameterValid(xEntityName, xId, yEntityName, yId)) {
            throw new ParameterMissingException(null);
        }

        String xTableName = ORM.lookup(xEntityName).getTableName();
        String yTableName = ORM.lookup(yEntityName).getTableName();

        if (hasBound(xTableName, xId, yTableName, yId) || hasBound(yTableName, yId, xTableName, xId)) {
            throw new RelationExistedException();
        }

        relationMapper.insert(xTableName, xId, yTableName, yId);
    }

    @Override
    public void unbind(String xEntityName, String xId, String yEntityName, String yId) {
        if (!isParameterValid(xEntityName, xId, yEntityName, yId)) {
            throw new ParameterMissingException(null);
        }

        String xTableName = ORM.lookup(xEntityName).getTableName();
        String yTableName = ORM.lookup(yEntityName).getTableName();

        if (!hasBound(xTableName, xId, yTableName, yId) && !hasBound(yTableName, yId, xTableName, xId)) {
            throw new RelationNotExistedException();
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
