package com.inesafujitsu.prototype.platform.commons.exception;

import com.inesafujitsu.prototype.platform.commons.support.StringUtils;

public class EntityRemoveNotAllowedException extends RuntimeException {

    public EntityRemoveNotAllowedException(String type, String key) {
        super(StringUtils.format("The %s (%s) is not allowed to remove!", type, key));
    }
}
