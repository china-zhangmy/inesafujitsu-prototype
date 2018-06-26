package com.inesafujitsu.prototype.platform.web.jersey.support;

public class Constants {

    // Resource Path
    public static final String APPLICATION_ROOT_RESOURCE = "prototype";

    public static final String ROOT_RESOURCE_HELLO_WORLD = "hello_world";
    public static final String ROOT_RESOURCE_ORGANIZATIONS = "organizations";
//    public static final String ROOT_RESOURCE_USER_GROUPS = "groups";
//    public static final String ROOT_RESOURCE_USERS = "users";
//    public static final String ROOT_RESOURCE_USERS = "organizations/{uri: ([a-z0-9]{32}\\/)*[a-z0-9]{32}}/users";
public static final String ROOT_RESOURCE_PRIVILEGES = "privileges";

    public static final String SUB_RESOURCE_LOCATOR_URI = "{uri: ([a-z0-9]{32}\\/)*[a-z0-9]{32}}";
    public static final String SUB_RESOURCE_LOCATOR_USER_GROUPS = "groups";
    public static final String SUB_RESOURCE_LOCATOR_USERS = "users";
    public static final String SUB_RESOURCE_LOCATOR_GROUP_ID = "{group_id}";

    public static final String SUB_RESOURCE_CHECK_DATABASE = "check_database";
    public static final String SUB_RESOURCE_ID = "{id}";
    public static final String SUB_RESOURCE_GROUP_ID = "{group_id}";
    public static final String SUB_RESOURCE_USER_ID = "{user_id}";
    public static final String SUB_RESOURCE_SUB_TYPES = "sub_types";
    public static final String SUB_RESOURCE_CODE = "{code}";

    // Path Param
    public static final String PATH_PARAM_ID = "id";
    public static final String PATH_PARAM_GROUP_ID = "group_id";
    public static final String PATH_PARAM_USER_ID = "user_id";
    public static final String PATH_PARAM_URI = "uri";
    public static final String PATH_PARAM_CODE = "code";

    // Query Param
    public static final String QUERY_PARAM_OPERATOR = "operator";
    public static final String QUERY_PARAM_TYPE_CODE = "type_code";

}
