package com.inesafujitsu.prototype.business.service.support;

public class Validator {

    public static boolean isValidUpdateOpt(String operator) {
        return UpdateOpt.lookup(operator) != null;
    }

}
