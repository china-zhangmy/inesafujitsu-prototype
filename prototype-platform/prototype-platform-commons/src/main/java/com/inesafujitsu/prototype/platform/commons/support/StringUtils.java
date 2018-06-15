package com.inesafujitsu.prototype.platform.commons.support;

public class StringUtils extends org.apache.commons.lang3.StringUtils {

    public static String format(String format, Object... args) {
        return String.format(format, args);
    }

}
