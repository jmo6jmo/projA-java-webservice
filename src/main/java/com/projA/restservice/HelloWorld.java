package com.projA.restservice;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/helloworld")
public class HelloWorld {
	private static final String template = "Hello, %s!";
	
	@GET
	@Path("/print/{name}")
	@Produces(MediaType.TEXT_PLAIN)
	public String print(@PathParam("name") String name) {
		return String.format(template, name);
	}
}
