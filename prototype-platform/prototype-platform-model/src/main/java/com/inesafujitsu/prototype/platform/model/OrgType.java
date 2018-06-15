package com.inesafujitsu.prototype.platform.model;

import java.util.HashMap;
import java.util.Map;

public enum OrgType {

    COMPANY("C"), DEPARTMENT("D"), GROUP("G");

    private String code;
    private static Map<String, OrgType> orgTypes = new HashMap<>();

    static {
        for (OrgType type : values()) {
            orgTypes.put(type.code, type);
        }
    }

    OrgType(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public static OrgType get(String code) {
        return orgTypes.get(code);
    }

}
