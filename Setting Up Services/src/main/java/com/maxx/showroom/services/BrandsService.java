package com.maxx.showroom.services;

import java.util.ArrayList;
import java.util.List;

import com.maxx.showroom.hibernate.entities.BrandEntity;
import com.maxx.showroom.hibernate.entities.DAO.BrandsDAO;

public class BrandsService {
	
	BrandsDAO DAO = new BrandsDAO();

	public List<BrandEntity> getBrands() {
		List<BrandEntity> list = new ArrayList<>(); 
		list = DAO.getBrands();
		return list;
	}

	public void addBrand(BrandEntity brand) {
		DAO.addBrand(brand);
		
	}

	public void updateBrand(BrandEntity updatedBrand) {
		// TODO Auto-generated method stub
		DAO.updateBrand(updatedBrand);
		
	}

	public void deleteBrand(int brandID) {
		// TODO Auto-generated method stub
		DAO.deleteBrand(brandID);
		
	}

	public BrandEntity getBrand(int brandID) {
		return DAO.getBrand(brandID);
	}

}
