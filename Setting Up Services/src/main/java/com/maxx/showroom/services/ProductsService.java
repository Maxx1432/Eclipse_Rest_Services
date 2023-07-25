package com.maxx.showroom.services;

import java.util.List;

import com.maxx.showroom.hibernate.entities.ProductEntity;
import com.maxx.showroom.hibernate.entities.DAO.ProductsDAO;

public class ProductsService {

	ProductsDAO dao = new ProductsDAO();
	
	public List<ProductEntity> getProductsByBrand(int brandId) {
		
		List<ProductEntity> productList = dao.getProductsByBrands(brandId);
		
		
		return productList;
	}

	public List<ProductEntity> getProductsByBrandAndCategory(int brandId, String category) {
		
		List<ProductEntity> productList = dao.getProductsByBrandAndCategory(brandId, category);
		
		return productList;
	}

}
