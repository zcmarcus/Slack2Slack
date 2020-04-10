package com.slack2slack.service;


import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

// Defines base URI for all resource URIs.
@ApplicationPath("/services")
// Java class declares root resources and provider classes
public class Slack2SlackApplication extends Application {

    //This method returns a non-empty collection with classes which must be published in the JAX-RS application
    @Override
    public Set<Class<?>> getClasses() {
        HashSet h = new HashSet<Class<?>>();
        h.add(TemplateService.class);
        return h;
    }
}

