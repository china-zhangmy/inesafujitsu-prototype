package com.inesafujitsu.prototype.platform.model.ctrl;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.inesafujitsu.prototype.platform.commons.model.Entity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonIgnoreProperties({"id", "compositeCodes"})
public class Privilege extends Entity {

    private String code;
    private String descr;
    private Type type;
    private String compositeCodes;

    private List<Privilege> composite;

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

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getCompositeCodes() {
        return compositeCodes;
    }

    public void setCompositeCodes(String compositeCodes) {
        this.compositeCodes = compositeCodes;
    }

    public List<Privilege> getComposite() {
        return composite;
    }

    public void setComposite(List<Privilege> composite) {
        this.composite = composite;
    }

    public static class Builder extends Entity.Builder<Privilege> {

        public Builder(Map<String, Object> args) {
            super(args);
        }

        @Override
        public Privilege build() {
            Privilege privilege = super.build(Privilege.class);

            privilege.setCode((String) args.get("code"));
            privilege.setDescr((String) args.get("descr"));
            privilege.setType((Type) args.get("type"));
            privilege.setCompositeCodes((String) args.get("compositeCodes"));

            return privilege;
        }
    }

    public enum Type {

        PRIVILEGE("P", "Privilege"), PRIVILEGE_GROUP("PG", "Privilege Group");

        private String code;
        private String descr;
        private static Map<String, Type> types = new HashMap<>();

        Type(String code, String descr) {
            this.code = code;
            this.descr = descr;
        }

        static {
            for (Type type : values()) {
                types.put(type.getCode(), type);
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
