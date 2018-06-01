package com.inesafujitsu.prototype.service.support;

public class Validator {

    public static boolean validateOperation(String operator) {
        return Operation.lookup(operator) != null;
    }

}
