package com.inesafujitsu.prototype.platform.model;

import com.inesafujitsu.prototype.platform.commons.model.Entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Org extends Entity {

    private String name;
    private String descr;
    private String typeCode;
    private Integer level;
    private String uri;

    private Org parent;
    private List<Org> children = new ArrayList<>();
    private List<User> users = new ArrayList<>();

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

    public String getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
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

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public static class Builder extends Entity.Builder<Org> {

        private Boolean forTop;

        public Builder(Map<String, Object> args) {
            super(args);
        }

        public Builder forTop(Boolean forTop) {
            this.forTop = forTop;
            return this;
        }

        @Override
        public Org build() {
            Org node = super.build(Org.class);

            node.setName((String) args.get("name"));
            node.setDescr((String) args.get("descr"));
            node.setTypeCode((String) args.get("typeCode"));

            if (forTop) {
                node.setLevel(1);
                node.setUri(node.getId());
            } else {
                Org parent = (Org) args.get("parent");
                if (parent != null) {
                    node.setParent(parent);
                    node.setLevel(parent.getLevel() + 1);
                    node.setUri(parent.getUri() + "/" + node.getId());
                }
            }

            return node;
        }
    }

    public static class Type {

        private String code;
        private String descr;

        private List<Type> children = new ArrayList<>();

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

        public List<Type> getChildren() {
            return children;
        }

        public void setChildren(List<Type> children) {
            this.children = children;
        }
    }
}
