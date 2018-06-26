package com.inesafujitsu.prototype.platform.commons.support;

import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class JsonUtils {

    public static <V> Map<String, V> jsonToMap(String json) throws IOException {
        return new ObjectMapper().readValue(json, Map.class);
    }

    public static <V> List<Map<String, V>> jsonToList(String json) throws IOException {
        return new ObjectMapper().readValue(json, List.class);
    }

}
