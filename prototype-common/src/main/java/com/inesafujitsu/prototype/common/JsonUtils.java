package com.inesafujitsu.prototype.common;

import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;
import java.util.Map;

public class JsonUtils {

    public static <V> Map<String, V> jsonToMap(String json) {
        Map map = null;

        try {
            map = new ObjectMapper().readValue(json, Map.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return map;
    }

}
