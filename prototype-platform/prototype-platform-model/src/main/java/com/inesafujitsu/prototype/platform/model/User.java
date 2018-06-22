package com.inesafujitsu.prototype.platform.model;

import com.inesafujitsu.prototype.platform.commons.model.Entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User extends Entity {

    private Type type;
    private String name;
    private String descr;
    private String password;
    private Integer age;
    private String email;
    private Gender gender;

    private Org org;
    private User group;
    private List<User> users = new ArrayList<>();


    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

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

    public User getGroup() {
        return group;
    }

    public void setGroup(User group) {
        this.group = group;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public static class Builder extends Entity.Builder<User> {

        public Builder(Map<String, Object> args) {
            super(args);
        }

        @Override
        public User build() {
            User user = super.build(User.class);

            Type type = (Type) args.get("type");
            user.setType(type);
            user.setName((String) args.get("name"));
            user.setOrg((Org) args.get("org"));

            if (Type.GROUP.equals(type)) {
                user.setDescr((String) args.get("descr"));
            }

            if (Type.USER.equals(type)) {
                user.setPassword((String) args.get("password"));
                user.setAge(Integer.valueOf(String.valueOf(args.get("age"))));
                user.setEmail((String) args.get("email"));
                user.setGender(Gender.get(String.valueOf(args.get("gender"))));
                user.setGroup((User) args.get("group"));
            }

            return user;
        }
    }

    public enum Gender {

        MALE("M", "Male"), FEMALE("F", "FEMALE");

        private String code;
        private String descr;
        private static Map<String, Gender> genders = new HashMap<>();

        Gender(String code, String descr) {
            this.code = code;
            this.descr = descr;
        }

        static {
            for (Gender gender : Gender.values()) {
                genders.put(gender.code, gender);
            }
        }

        public String getCode() {
            return code;
        }

        public static Gender get(String code) {
            return genders.get(code);
        }
    }

    public enum Type {

        USER("U", "user"), GROUP("G", "Group");

        private String code;
        private String descr;
        private static Map<String, Type> types = new HashMap<>();

        Type(String code, String descr) {
            this.code = code;
            this.descr = descr;
        }

        static {
            for (Type type : Type.values()) {
                types.put(type.code, type);
            }
        }

        public String getCode() {
            return code;
        }

        public static Type get(String code) {
            return types.get(code);
        }
    }

}
