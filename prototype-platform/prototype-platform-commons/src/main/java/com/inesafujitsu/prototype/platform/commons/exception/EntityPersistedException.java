package com.inesafujitsu.prototype.platform.commons.exception;

import com.inesafujitsu.prototype.platform.commons.support.StringUtils;

public class EntityPersistedException extends RuntimeException {

    public EntityPersistedException(String type, String key) {
        super(StringUtils.format("The %s (%s) has been persisted already!", type, key));
    }
}
