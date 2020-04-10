package com.mcanoy;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.metrics.annotation.Counted;
import org.eclipse.microprofile.metrics.annotation.Timed;

@Path("/version")
public class Version {
	
	@ConfigProperty(name = "com.mcanoy.version")
	String version;
	
	@GET
    @Produces(MediaType.APPLICATION_JSON)
    @Counted(name="versionCounter")
    @Timed(name="versionTimer")
    public String version(@QueryParam(value="greetings") String greetings) {
        return String.format("{\"version\": \"%s\"}", version);
    }

}
