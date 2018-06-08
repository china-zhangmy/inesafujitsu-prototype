package com.inesafujitsu.prototype.model.business;

import java.util.Map;

public class MaskHistory extends History {

    public static class Builder extends History.Builder<MaskHistory> {

        public Builder(Map<String, Object> args) {
            super(args);
        }

        public MaskHistory build() {
            MaskHistory maskHistory = super.build(MaskHistory.class);

            return maskHistory;
        }
    }
}
