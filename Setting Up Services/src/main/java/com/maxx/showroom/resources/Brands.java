package com.maxx.showroom.resources;


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

import jakarta.ws.rs.Consumes;
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
	
	BrandsService service = new BrandsService();

	@GET
	@Path("/brands")
	@Produces(MediaType.APPLICATION_JSON)
	//showroom/getBrands
	public List<BrandEntity> getBrands() {
		List<BrandEntity> list = new ArrayList<>();
		list =	service.getBrands();
		return list;
	}
	
	@POST
	@Path("/brands")
	@Consumes(MediaType.APPLICATION_JSON)
	//showroom/getBrands
	public void postBrands(BrandEntity brand) {
		service.addBrand(brand);
	}
	
	@PUT
	@Path("/brands/{brandId}")
	@Consumes(MediaType.APPLICATION_JSON)
	//showroom/getBrands
	public void putBrands(@PathParam("brandId") int brandID, BrandEntity updatedBrand) {
		updatedBrand.setBrandId(brandID);
		service.updateBrand(updatedBrand);
	}
	
	@DELETE
	@Path("/brands/{brandId}")
	@Consumes(MediaType.APPLICATION_JSON)
	//showroom/getBrands
	public void deleteBrands(@PathParam("brandId") int brandID) {
		service.deleteBrand(brandID);
	}
}
