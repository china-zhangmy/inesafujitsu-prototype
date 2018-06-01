package com.inesafujitsu.prototype.model.base;

import java.util.Map;

public class Mask extends Master {

    private String rfId;

    public String getRfId() {
        return rfId;
    }

    public void setRfId(String rfId) {
        this.rfId = rfId;
    }

    public static class Builder extends Master.Builder<Mask> {

        public Builder(Map<String, Object> args) {
            super(args);
        }

        public Mask build() {
            Mask mask = super.build(Mask.class);

            mask.setRfId((String) args.get("rfId"));

            return mask;
        }
    }
}
