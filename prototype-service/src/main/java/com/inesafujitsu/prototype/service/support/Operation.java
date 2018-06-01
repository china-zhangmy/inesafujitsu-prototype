package com.inesafujitsu.prototype.service.support;

import org.apache.commons.lang3.StringUtils;

public enum Operation {

    UPDATE(null, "Update"), CHECK_OUT("checkout", "Check Out"), CHECK_IN("checkin", "Check In");

    private String operator;
    private String desc;

    Operation(String operator, String desc) {
        this.operator = operator;
        this.desc = desc;
    }

    public static Operation lookup(String operator) {
        if (StringUtils.isBlank(operator)) {
            return UPDATE;
        }

        operator = operator.toLowerCase().replace("_-", "");

        for (Operation operation : values()) {
            if (operator.equals(operation.operator)) {
                return operation;
            }
        }

        return null;
    }
}
