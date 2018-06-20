package com.inesafujitsu.prototype.platform.web.jersey.support;

public class Constants {

    // Resource Path
    public static final String APPLICATION_ROOT_RESOURCE = "prototype";

    public static final String ROOT_RESOURCE_HELLO_WORLD = "hello_world";
    public static final String ROOT_RESOURCE_ORGANIZATIONS = "organizations";
    public static final String ROOT_RESOURCE_USERS = "organizations/{uri: ([a-z0-9]{32}\\/)*[a-z0-9]{32}}/users";

    public static final String SUB_RESOURCE_LOCATOR_URI = "{uri: ([a-z0-9]{32}\\/)*[a-z0-9]{32}}";

    public static final String SUB_RESOURCE_CHECK_DATABASE = "check_database";
    public static final String SUB_RESOURCE_ID = "{id}";
    public static final String SUB_RESOURCE_SUB_TYPES = "sub_types";

    // Path Param
    public static final String PATH_PARAM_ID = "id";
    public static final String PATH_PARAM_URI = "uri";

    // Query Param
    public static final String QUERY_PARAM_OPERATOR = "operator";
    public static final String QUERY_PARAM_TYPE_CODE = "type_code";

}
