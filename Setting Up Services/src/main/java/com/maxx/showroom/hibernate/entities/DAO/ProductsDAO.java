package com.maxx.showroom.hibernate.entities.DAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.maxx.showroom.hibernate.entities.BrandEntity;
import com.maxx.showroom.hibernate.entities.ProductEntity;

public class ProductsDAO { 

	SessionFactory factory = new Configuration()
			.configure("hibernate.cfg.xml")
			.addAnnotatedClass(ProductEntity.class)
			.addAnnotatedClass(BrandEntity.class)
			.buildSessionFactory();
	String sql;

	public List<ProductEntity> getProductsByBrands(int brandId) {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		List<ProductEntity> prductList = new ArrayList<>();
		sql = "from product where brandID = '"+brandId+"'";
		prductList = session.createQuery(sql).getResultList();
		return prductList;

	}

	public List<ProductEntity> getProductsByBrandAndCategory(int brandId, String category) {
		
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		List<ProductEntity> prductList;
		sql = "from product where brandID = '"+brandId+"' and category= '"+category+"'";
		prductList = session.createQuery(sql).getResultList();
		return prductList;
	}
}
