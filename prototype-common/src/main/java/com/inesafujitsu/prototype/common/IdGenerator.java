package com.inesafujitsu.prototype.common;

import java.util.UUID;

public class IdGenerator {

    public static String generateId() {
        return UUID.randomUUID().toString().toLowerCase().replace("-", "");
    }

}
