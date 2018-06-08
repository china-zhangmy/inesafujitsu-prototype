package com.inesafujitsu.prototype.model.platform;

import com.inesafujitsu.prototype.model.Entity;

import java.util.List;

public class Department extends Entity {

    private String name;
    private List<User> users;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
