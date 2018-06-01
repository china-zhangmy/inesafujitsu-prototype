package com.inesafujitsu.prototype.web.jersey.support;

public class Constants {

    // Resource Path
    public static final String RESOURCE_APPLICATION_ROOT = "prototype";

    public static final String RESOURCE_ROOT_HELLO_WORLD = "hello_world";
    public static final String RESOURCE_ROOT_USER = "users";
    public static final String RESOURCE_ROOT_DEPARTMENT = "departments";
    public static final String RESOURCE_ROOT_MASK = "masks";

    public static final String RESOURCE_CHECK_DATABASE = "check_database";
    public static final String RESOURCE_ONE = "{id}";
    public static final String RESOURCE_ONE_MASTER_ALL_HISTORIES = "{master_id}/histories";
    public static final String RESOURCE_ONE_MASTER_ONE_HISTORY = "{master_id}/histories/{idx}";

    // Path Param
    public static final String PATH_PARAM_ID = "id";
    public static final String PATH_PARAM_MASTER_ID = "master_id";
    public static final String PATH_PARAM_IDX = "idx";

    // Query Param
    public static final String QUERY_PARAM_OPERATOR = "operator";

}
