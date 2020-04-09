package com.mcanoy;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.metrics.annotation.Counted;
import org.eclipse.microprofile.metrics.annotation.Timed;

@Path("/hello")
public class ExampleResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Counted(name="helloCounter", description="Counts invocations of hello")
    @Timed(name="heeloTime", description="Timing of hello")
    public String hello(@QueryParam(value="greetings") String greetings) {
        return String.format("hello %s", greetings == null ? "Mitch" : greetings);
    }
}