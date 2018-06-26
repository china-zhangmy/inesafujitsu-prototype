package com.inesafujitsu.prototype.platform.model.orgchart;

import com.inesafujitsu.prototype.platform.commons.model.Entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Group extends Entity {

    private String name;
    private String descr;

    private Org org;
    private List<Group> users = new ArrayList<>();

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

    public List<Group> getUsers() {
        return users;
    }

    public void setUsers(List<Group> users) {
        this.users = users;
    }

    public static class Builder extends Entity.Builder<Group> {

        public Builder(Map<String, Object> args) {
            super(args);
        }

        @Override
        public Group build() {
            Group group = super.build(Group.class);

            group.setName((String) args.get("name"));
            group.setDescr((String) args.get("descr"));
            group.setOrg((Org) args.get("org"));

            return group;
        }
    }

}
