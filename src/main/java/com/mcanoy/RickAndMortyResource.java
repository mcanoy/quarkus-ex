package com.mcanoy;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.metrics.annotation.Counted;
import org.eclipse.microprofile.metrics.annotation.Timed;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("/rickandmorty")
public class RickAndMortyResource {
	public static Logger LOGGER = LoggerFactory.getLogger(RickAndMortyResource.class);
	
	@Inject
	@RestClient
	RickAndMortyRestClient pickleRick;
	
	@GET
	@Path("/episode")
    @Produces(MediaType.APPLICATION_JSON)
    @Counted(name="rickCounter")
    @Timed(name="rickTimer")
    public RickAndMortyEpisode getEpisode(@QueryParam(value="episode") int episode) {
		LOGGER.info("episode {}", episode);
        return pickleRick.getEpisode(episode);
    }

}
