package com.inesafujitsu.prototype.service.support;

import org.apache.commons.lang3.StringUtils;

public enum UpdateOpt {

    UPDATE("update", "Update"),
    CHECK_OUT("checkout", "Check Out"),
    CHECK_IN("checkin", "Check In");

    private String operator;
    private String desc;

    UpdateOpt(String operator, String desc) {
        this.operator = operator;
        this.desc = desc;
    }

    public static UpdateOpt lookup(String operator) {
        if (StringUtils.isNotBlank(operator)) {
            operator = operator.toLowerCase().replaceAll("[ _-]", "");

            for (UpdateOpt updateOpt : values()) {
                if (updateOpt.operator.equals(operator)) {
                    return updateOpt;
                }
            }
        }

        return null;
    }
}
