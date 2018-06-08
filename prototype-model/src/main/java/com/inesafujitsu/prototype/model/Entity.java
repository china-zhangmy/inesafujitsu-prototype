package com.inesafujitsu.prototype.model;

import java.io.Serializable;
import java.util.Map;

public abstract class Entity implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public abstract static class Builder<T extends Entity> {

        protected Map<String, Object> args;

        public Builder(Map<String, Object> args) {
            this.args = args;
        }

        public abstract T build();

        public T build(Class<T> clazz) {
            T entity = null;

            try {
                entity = clazz.newInstance();
            } catch (IllegalAccessException | InstantiationException e) {
                //TODO
                e.printStackTrace();
            }

            return entity;
        }

    }
}
