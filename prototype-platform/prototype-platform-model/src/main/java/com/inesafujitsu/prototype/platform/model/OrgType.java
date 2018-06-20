package com.inesafujitsu.prototype.platform.model;

import java.util.List;

public class OrgType {

    private String code;
    private String descr;

    private List<OrgType> children;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public List<OrgType> getChildren() {
        return children;
    }

    public void setChildren(List<OrgType> children) {
        this.children = children;
    }
}
