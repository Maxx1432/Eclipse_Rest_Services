package com.maxx.showroom.resources;


import java.net.URI;
import java.util.ArrayList;
import java.util.List;


//import javax.ws.rs.Consumes;
//import javax.ws.rs.DELETE;
//import javax.ws.rs.GET;
//import javax.ws.rs.POST;
//import javax.ws.rs.PUT;
//import javax.ws.rs.Path;
//import javax.ws.rs.PathParam;
//import javax.ws.rs.Produces;
//import javax.ws.rs.core.MediaType;

import com.maxx.showroom.hibernate.entities.BrandEntity;
import com.maxx.showroom.services.BrandsService;
import com.maxx.showroom.services.ProductsService;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriInfo;


@Path("/showroom/brands")
public class Brands {
	
	BrandsService service = new BrandsService();
	ProductsService pService = new ProductsService();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	//showroom/getBrands
	public List<BrandEntity> getBrands() {
		List<BrandEntity> list = new ArrayList<>();
		list =	service.getBrands();
		return list;
	}
	
	@GET
	@Path("/{brandId}")
	@Produces(MediaType.APPLICATION_JSON)
	public BrandEntity getBrand(@PathParam("brandId") int brandID)
	{
		return service.getBrand(brandID);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	//showroom/getBrands
	public Response postBrands(BrandEntity brand, @Context UriInfo uri) {
//		URI location = uri.getAbsolutePath();
		service.addBrand(brand);
		//Easy way to build URI patj with ID
		URI location = uri.getAbsolutePathBuilder().path(Integer.toString(brand.getBrandId())).build();
//		String resourceURL = uri.getAbsolutePath().toString()+"/"+brand.getBrandId();
//		URI location = URI.create(resourceURL); 
		return Response.created(location).entity(brand).build();
	}
	
	@PUT
	@Path("/{brandId}")
	@Consumes(MediaType.APPLICATION_JSON)
	//showroom/getBrands
	public void putBrands(@PathParam("brandId") int brandID, BrandEntity updatedBrand) {
		updatedBrand.setBrandId(brandID);
		service.updateBrand(updatedBrand);
	}
	
	@DELETE
	@Path("/{brandId}")
	@Consumes(MediaType.APPLICATION_JSON)
	//showroom/getBrands
	public void deleteBrands(@PathParam("brandId") int brandID) {
		service.deleteBrand(brandID);
	}
	
	@Path("/{brandId}/products")
	 public Products productDelegate() {
		 return new Products();
	 }
	
}
