package com.maxx.showroom.hibernate.entities.DAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.maxx.showroom.hibernate.entities.BrandEntity;


public class BrandsDAO {

	SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(BrandEntity.class)
								.buildSessionFactory();
	
	public List<BrandEntity> getBrands() {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		List<BrandEntity> list = new ArrayList<>(); 
		list = session.createQuery("from brands").getResultList();
		return list;
		// TODO Auto-generated method stub
		
	}
	
	public BrandEntity getBrand(int brandID) {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
//		BrandEntity brand;
//		brand = session.get(BrandEntity.class, brandID);
		return session.get(BrandEntity.class, brandID);
		
	}

	public void addBrand(BrandEntity brand) {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		session.save(brand);
		session.getTransaction().commit();
		
	}

	public void updateBrand(BrandEntity updatedBrand) {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		int id = updatedBrand.getBrandId();
		BrandEntity brand = session.get(BrandEntity.class, id);
//		brand = updatedBrand;
		brand.setBrandName(updatedBrand.getBrandName());
		session.getTransaction().commit();
		
	}

	public void deleteBrand(int brandID) {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		BrandEntity brand = session.get(BrandEntity.class, brandID);
		session.delete(brand);
		session.getTransaction().commit();
	}


}
