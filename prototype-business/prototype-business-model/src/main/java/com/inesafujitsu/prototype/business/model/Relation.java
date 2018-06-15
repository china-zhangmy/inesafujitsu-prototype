package com.inesafujitsu.prototype.business.model;

public class Relation {

    private String xTableName;
    private String xId;
    private String yTableName;
    private String yId;

    public String getxTableName() {
        return xTableName;
    }

    public void setxTableName(String xTableName) {
        this.xTableName = xTableName;
    }

    public String getxId() {
        return xId;
    }

    public void setxId(String xId) {
        this.xId = xId;
    }

    public String getyTableName() {
        return yTableName;
    }

    public void setyTableName(String yTableName) {
        this.yTableName = yTableName;
    }

    public String getyId() {
        return yId;
    }

    public void setyId(String yId) {
        this.yId = yId;
    }
}
