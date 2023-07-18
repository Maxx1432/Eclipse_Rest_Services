package com.maxx.showroom.resources;


import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/showroom")
public class Brands {

	@GET
	@Path("/brands")
	@Produces(MediaType.TEXT_PLAIN)
	//showroom/getBrands
	public String getBrands() {
		return "list of Brands";
	}
	
	@POST
	@Path("/brands")
	@Produces(MediaType.TEXT_PLAIN)
	//showroom/getBrands
	public String postBrands() {
		return "Add a new Brand";
	}
	
	@PUT
	@Path("/brands/{brandId}")
	@Produces(MediaType.TEXT_PLAIN)
	//showroom/getBrands
	public String putBrands(@PathParam("brandId") String brandID) {
		return "Update Brand INFO with ID "+brandID;
	}
	
	@DELETE
	@Path("/brands/{brandId}")
	@Produces(MediaType.TEXT_PLAIN)
	//showroom/getBrands
	public String deleteBrands(@PathParam("brandId") int brandID) {
		return "Delete Brand from DB with ID "+brandID;
	}
}
