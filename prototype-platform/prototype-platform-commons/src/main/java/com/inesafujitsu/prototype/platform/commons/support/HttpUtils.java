package com.inesafujitsu.prototype.platform.commons.support;

import com.inesafujitsu.prototype.platform.commons.exception.ParameterInvalidException;

import java.io.IOException;
import java.util.Map;

public class HttpUtils {

    public static Map<String, Object> parseRequestBody(String requestBody) {
        try {
            return JsonUtils.jsonToMap(requestBody);
        } catch (IOException e) {
            throw new ParameterInvalidException(StringUtils.isBlank(requestBody) ? "request body blank" : requestBody);
        }
    }

}
