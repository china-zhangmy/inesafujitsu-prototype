package com.inesafujitsu.prototype.model.business;

import com.inesafujitsu.prototype.model.Entity;

import java.util.Date;
import java.util.Map;

public abstract class History extends Entity {

    private Master master;
    private Integer idx;
    private Date createDate;
    private String createUser;
    private String note;

    public Master getMaster() {
        return master;
    }

    public void setMaster(Master master) {
        this.master = master;
    }

    public Integer getIdx() {
        return idx;
    }

    public void setIdx(Integer idx) {
        this.idx = idx;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public abstract static class Builder<T extends History> extends Entity.Builder<T> {

        public Builder(Map<String, Object> args) {
            super(args);
        }

        @Override
        public T build(Class<T> clazz) {
            T history = super.build(clazz);

            history.setId((String) args.get("id"));
            history.setMaster((Master) args.get("master"));
            history.setIdx((Integer) args.get("idx"));
            history.setCreateDate((Date) args.get("createDate"));
            history.setCreateUser((String) args.get("createUser"));
            history.setNote((String) args.get("note"));

            return history;
        }
    }
}
