package com.inesafujitsu.prototype.platform.model.orgchart;

import com.inesafujitsu.prototype.platform.commons.model.Entity;

import java.util.HashMap;
import java.util.Map;

public class User extends Entity {

    private String name;
    private String password;
    private Integer age;
    private String email;
    private Gender gender;

    private Org org;
    private Group group;
    private User superior;

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

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public User getSuperior() {
        return superior;
    }

    public void setSuperior(User superior) {
        this.superior = superior;
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
            user.setOrg((Org) args.get("org"));
            user.setGroup((Group) args.get("group"));
            user.setSuperior((User) args.get("superior"));

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

}
