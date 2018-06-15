package com.inesafujitsu.prototype.business.model;

import com.inesafujitsu.prototype.business.model.abs.Master;

import java.util.Map;

public class Mask extends Master {

    private String transportBoxRfId;

    public String getTransportBoxRfId() {
        return transportBoxRfId;
    }

    public void setTransportBoxRfId(String transportBoxRfId) {
        this.transportBoxRfId = transportBoxRfId;
    }

    public static class Builder extends Master.Builder<Mask> {

        public Builder(Map<String, Object> args) {
            super(args);
        }

        public Mask build() {
            Mask mask = super.build(Mask.class);

            mask.setTransportBoxRfId((String) args.get("transportBoxRfId"));

            return mask;
        }
    }
}
