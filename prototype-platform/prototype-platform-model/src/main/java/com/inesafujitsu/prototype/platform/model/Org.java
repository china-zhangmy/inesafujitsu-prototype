package com.inesafujitsu.prototype.platform.model;

import com.inesafujitsu.prototype.platform.commons.model.Entity;

import java.util.List;
import java.util.Map;

public class Org extends Entity {

    private String name;
    private String descr;
    private OrgType type;
    private Integer level;
    private String uri;

    private Org parent;
    private List<Org> children;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public OrgType getType() {
        return type;
    }

    public void setType(OrgType type) {
        this.type = type;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public Org getParent() {
        return parent;
    }

    public void setParent(Org parent) {
        this.parent = parent;
    }

    public List<Org> getChildren() {
        return children;
    }

    public void setChildren(List<Org> children) {
        this.children = children;
    }

    public static class Builder extends Entity.Builder<Org> {

        public Builder(Map<String, Object> args) {
            super(args);
        }

        @Override
        public Org build() {
            Org node = super.build(Org.class);

            node.setName((String) args.get("name"));
            node.setDescr((String) args.get("descr"));
            node.setType(OrgType.get((String) args.get("typeCode")));
            Org parent = (Org) args.get("parent");
            node.setParent(parent);
            node.setLevel(parent == null ? 1 : parent.getLevel() + 1);
            node.setUri(parent == null ? node.getId() : parent.getUri() + "/" + node.getId());

            return node;
        }
    }
}
