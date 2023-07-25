package com.maxx.showroom.resources;

import java.util.ArrayList;
import java.util.List;

import com.maxx.showroom.hibernate.entities.ProductEntity;
import com.maxx.showroom.services.ProductsService;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

public class Products {
	
	ProductsService pService = new ProductsService();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	//showroom/getBrands
	public List<ProductEntity> geProductsByBrands(@PathParam("brandId") int brandId, @QueryParam("category") String category,
	@QueryParam("start") int start, @QueryParam("end") int end ){
		List<ProductEntity> productList;
		if(category != null ) {
			productList = pService.getProductsByBrandAndCategory(brandId, category);
		}
		else {
		
			productList =	pService.getProductsByBrand(brandId);
		}
		if(end > 0)
		{
			productList = productList.subList(start, end);
		}
		return productList;
	}
}
