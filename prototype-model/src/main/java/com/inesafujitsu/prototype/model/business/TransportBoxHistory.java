package com.inesafujitsu.prototype.model.business;

import java.util.Map;

public class TransportBoxHistory extends History {

    public static class Builder extends History.Builder<TransportBoxHistory> {

        public Builder(Map<String, Object> args) {
            super(args);
        }

        public TransportBoxHistory build() {
            TransportBoxHistory transportBoxHistory = super.build(TransportBoxHistory.class);

            return transportBoxHistory;
        }
    }

}
