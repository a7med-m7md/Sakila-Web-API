package com.iti;

import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.ServerProperties;


@ApplicationPath("webapi")
public class ApplicationConfig extends ResourceConfig {
    public ApplicationConfig(){
        packages("com.iti.controllers.rest");
        property(ServerProperties.BV_FEATURE_DISABLE, true);
    }
}
