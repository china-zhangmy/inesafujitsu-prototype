package com.inesafujitsu.prototype.service.support;

public class Validator {

    public static boolean isValidUpdateOpt(String operator) {
        return UpdateOpt.lookup(operator) != null;
    }

}
