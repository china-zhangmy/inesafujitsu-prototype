package com.inesafujitsu.prototype.platform.commons.exception;

import com.inesafujitsu.prototype.platform.commons.support.StringUtils;

public class EntityNotPersistedException extends RuntimeException {

    public EntityNotPersistedException(String type, String key) {
        super(StringUtils.format("The %s (%s) has not been persisted!", type, key));
    }
}
