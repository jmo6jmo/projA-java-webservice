package com.projA.webservice.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;

import com.projA.jpa.example.Test;

@Path("/testmongodb")
public class TestMongoDB {
	
	@Autowired
	private Test test;
	
	@GET
	@Path("/findcustomer/{name}")
	@Produces(MediaType.TEXT_PLAIN)
	public String print(@PathParam("name") String name) {
		return test.testFindCustomer(name).toString();
	}
}
