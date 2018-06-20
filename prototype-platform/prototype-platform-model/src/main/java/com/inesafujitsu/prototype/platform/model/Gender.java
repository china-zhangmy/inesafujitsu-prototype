package com.inesafujitsu.prototype.platform.model;

import java.util.HashMap;
import java.util.Map;

public enum Gender {

    MALE("M", "Male"), FEMALE("F", "FEMALE");

    private String code;
    private String descr;
    private static Map<String, Gender> genders = new HashMap<>();

    Gender(String code, String descr) {
        this.code = code;
        this.descr = descr;
    }

    static {
        for (Gender gender : values()) {
            genders.put(gender.code, gender);
        }
    }

    public String getCode() {
        return code;
    }

    public static Gender get(String code) {
        return genders.get(code);
    }
}
