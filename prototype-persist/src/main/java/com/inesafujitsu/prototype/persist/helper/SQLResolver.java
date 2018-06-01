package com.inesafujitsu.prototype.persist.helper;

import org.apache.commons.lang3.StringUtils;

import java.util.List;

public class SQLResolver {

    private String table;
    private String id;
    private String where;
    private List<String> columns;
    private List<Object> values;

    public SQLResolver table(String table) {
        this.table = table;
        return this;
    }

    public SQLResolver id(String id) {
        this.id = id;
        return this;
    }

    public SQLResolver where(String where) {
        this.where = where;
        return this;
    }

    public SQLResolver columns(List<String> columns) {
        this.columns = columns;
        return this;
    }

    public String getTable() {
        return table;
    }

    public String getId() {
        return id;
    }

    public String getWhere() {
        return where;
    }

    public String getColumns() {
        return StringUtils.join(this.columns, ",");
    }

    public String getValues() {
        return StringUtils.join(this.values, ",");
    }
}
