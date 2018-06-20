package com.inesafujitsu.prototype.platform.model;

import com.inesafujitsu.prototype.platform.commons.model.Entity;

import java.util.Map;

public class User extends Entity {

    private String name;
    private String password;
    private Integer age;
    private String email;
    private Gender gender;

    private Org org;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Org getOrg() {
        return org;
    }

    public void setOrg(Org org) {
        this.org = org;
    }

    public static class Builder extends Entity.Builder<User> {

        public Builder(Map<String, Object> args) {
            super(args);
        }

        @Override
        public User build() {
            User user = super.build(User.class);

            user.setName((String) args.get("name"));
            user.setPassword((String) args.get("password"));
            user.setAge(Integer.valueOf(String.valueOf(args.get("age"))));
            user.setEmail((String) args.get("email"));
            user.setGender(Gender.get(String.valueOf(args.get("gender"))));
            Org org = (Org) args.get("org");
            user.setOrg(org);

            return user;
        }
    }
}
