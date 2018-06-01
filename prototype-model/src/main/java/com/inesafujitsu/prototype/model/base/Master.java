package com.inesafujitsu.prototype.model.base;

import com.inesafujitsu.prototype.model.Entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public abstract class Master extends Entity {

    private String name;
    private Integer currIdx;
    private Date createDate;
    private String createUser;
    private Date updateDate;
    private String updateUser;
    private Date lockDate;
    private String lockUser;

    private List<History> histories = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCurrIdx() {
        return currIdx;
    }

    public void setCurrIdx(Integer currIdx) {
        this.currIdx = currIdx;
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

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    public Date getLockDate() {
        return lockDate;
    }

    public void setLockDate(Date lockDate) {
        this.lockDate = lockDate;
    }

    public String getLockUser() {
        return lockUser;
    }

    public void setLockUser(String lockUser) {
        this.lockUser = lockUser;
    }

    public List<History> getHistories() {
        return histories;
    }

    public void setHistories(List<History> histories) {
        this.histories = histories;
    }

    public abstract static class Builder<T extends Master> extends Entity.Builder<T> {

        public Builder(Map<String, Object> args) {
            super(args);
        }

        @Override
        public T build(Class<T> clazz) {
            T master = super.build(clazz);

            master.setId((String) args.get("id"));
            master.setCurrIdx((Integer) args.get("currIdx"));
            master.setCreateDate((Date) args.get("createDate"));
            master.setCreateUser((String) args.get("createUser"));
            master.setUpdateDate((Date) args.get("updateDate"));
            master.setUpdateUser((String) args.get("updateUser"));
            master.setLockDate((Date) args.get("lockDate"));
            master.setLockUser((String) args.get("lockUser"));

            return master;
        }
    }
}
