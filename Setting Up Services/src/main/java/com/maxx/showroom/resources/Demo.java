package com.maxx.showroom.resources;

import jakarta.servlet.ServletContext;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.HeaderParam;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.UriInfo;

@Path("/")
@Produces(MediaType.TEXT_PLAIN)
public class Demo {

	@Context
	private UriInfo uriInfo;
	
	@Context
	private ServletContext servletContext;
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String useFulAnnotations() {
		return "Hello Jax-RS";
	}
	
	@GET
	@Path("demo")
	public String conetxtDemo(@HeaderParam("header") String header) throws Exception{
		if(header != null)
		return "The value of custom header value is : "+header;
		else
		{
			throw new WebApplicationException("The value of custom header not found",404);
		}
	}
}
