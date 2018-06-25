package com.inesafujitsu.prototype.platform.model;

import com.inesafujitsu.prototype.platform.commons.model.Entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UserGroup extends Entity {

    private String name;
    private String descr;

    private Org org;
    private List<UserGroup> users = new ArrayList<>();

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

    public Org getOrg() {
        return org;
    }

    public void setOrg(Org org) {
        this.org = org;
    }

    public List<UserGroup> getUsers() {
        return users;
    }

    public void setUsers(List<UserGroup> users) {
        this.users = users;
    }

    public static class Builder extends Entity.Builder<UserGroup> {

        public Builder(Map<String, Object> args) {
            super(args);
        }

        @Override
        public UserGroup build() {
            UserGroup userGroup = super.build(UserGroup.class);

            userGroup.setName((String) args.get("name"));
            userGroup.setDescr((String) args.get("descr"));
            userGroup.setOrg((Org) args.get("org"));

            return userGroup;
        }
    }

}
