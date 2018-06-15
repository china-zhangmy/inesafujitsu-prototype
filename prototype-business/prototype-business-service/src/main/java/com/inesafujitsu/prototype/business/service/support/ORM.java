package com.inesafujitsu.prototype.business.service.support;

import org.apache.commons.lang3.StringUtils;

public enum ORM {

    MASK("mask", "m_mask"),
    TRANSPORT_BOX("transportbox", "m_transport_box");

    private String entityName;
    private String tableName;

    ORM(String entityName, String tableName) {
        this.entityName = entityName;
        this.tableName = tableName;
    }

    public String getEntityName() {
        return entityName;
    }

    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public static ORM lookup(String entityName) {
        if (StringUtils.isNotBlank(entityName)) {
            entityName = entityName.toLowerCase().replaceAll("[ _-]", "");

            for (ORM orm : values()) {
                if (orm.entityName.equals(entityName)) {
                    return orm;
                }
            }
        }

        return null;
    }

}
