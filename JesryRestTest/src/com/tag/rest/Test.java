package com.tag.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/test/{param:[A-Z]*}")
public class Test {

	/*@GET
	@Produces(MediaType.TEXT_HTML)
	public String getMessage(@PathParam("param") String message) {  
		  String output = "Jersey say Hello World!!! : " + message;  
		 // return Response.status(200).entity(output).build();
		  return output;
		 } */ 
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getMessage1(@PathParam("param") String message) {  
		  String output = "Jersey say Hello World!!! : " + message;  
		 // return Response.status(200).entity(output).build();
		  return output;
		 } 
}
