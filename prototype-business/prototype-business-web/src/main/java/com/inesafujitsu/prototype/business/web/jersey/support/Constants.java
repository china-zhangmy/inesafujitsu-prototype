package com.inesafujitsu.prototype.business.web.jersey.support;

public class Constants {

    // Resource Path
    public static final String APPLICATION_ROOT_RESOURCE = "prototype";

    public static final String ROOT_RESOURCE_MASK = "masks";
    public static final String ROOT_RESOURCE_TRANSPORT_BOXES = "transport_boxes";
    public static final String ROOT_RESOURCE_RELATION = "relation";

    public static final String SUB_RESOURCE_ID = "{id}";
    public static final String SUB_RESOURCE_ONE_MASTER_ALL_HISTORIES = "{master_id}/histories";
    public static final String SUB_RESOURCE_ONE_MASTER_ONE_HISTORY = "{master_id}/histories/{idx}";
    public static final String SUB_RESOURCE_RELATION_BINDING = "binding/{x_id}@{x_entity_name},{y_id}@{y_entity_name}";
    public static final String SUB_RESOURCE_RELATION_UNBINDING = "unbinding/{x_id}@{x_entity_name},{y_id}@{y_entity_name}";

    // Path Param
    public static final String PATH_PARAM_ID = "id";
    public static final String PATH_PARAM_MASTER_ID = "master_id";
    public static final String PATH_PARAM_IDX = "idx";
    public static final String PATH_PARAM_RELATION_X_ENTITY_NAME = "x_entity_name";
    public static final String PATH_PARAM_RELATION_X_ID = "x_id";
    public static final String PATH_PARAM_RELATION_Y_ENTITY_NAME = "y_entity_name";
    public static final String PATH_PARAM_RELATION_Y_ID = "y_id";

    // Query Param
    public static final String QUERY_PARAM_OPERATOR = "operator";

}
