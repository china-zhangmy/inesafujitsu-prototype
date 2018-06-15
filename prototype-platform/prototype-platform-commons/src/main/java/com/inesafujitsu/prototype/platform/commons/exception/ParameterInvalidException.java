package com.inesafujitsu.prototype.platform.commons.exception;

import com.inesafujitsu.prototype.platform.commons.support.StringUtils;

public class ParameterInvalidException extends RuntimeException {

    public ParameterInvalidException(String... paras) {
        super(StringUtils.format("There might be some parameters(%s) invalid!", StringUtils.join(paras, ",")));
    }
}
