package com.inesafujitsu.prototype.business.model;

import com.inesafujitsu.prototype.business.model.abs.Master;

import java.util.Map;

public class TransportBox extends Master {

    private String rfId;

    public String getRfId() {
        return rfId;
    }

    public void setRfId(String rfId) {
        this.rfId = rfId;
    }

    public static class Builder extends Master.Builder<TransportBox> {

        public Builder(Map<String, Object> args) {
            super(args);
        }

        public TransportBox build() {
            TransportBox transportBox = super.build(TransportBox.class);

            transportBox.setRfId((String) args.get("rfId"));

            return transportBox;
        }
    }
}
