package com.inesafujitsu.prototype;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import javax.ws.rs.ApplicationPath;

@Component
@ApplicationPath("prototype")
public class PrototypeResourceConfig extends ResourceConfig {

    public PrototypeResourceConfig() {
    }

}
