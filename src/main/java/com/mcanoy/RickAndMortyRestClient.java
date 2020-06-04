package com.mcanoy;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

@RegisterRestClient(configKey = "rick.and.morty.api")
@Path("/api")
public interface RickAndMortyRestClient {

	
	@GET
	@Path("/episode/{id}")
	public RickAndMortyEpisode getEpisode(@PathParam("id") int id);
}
