package com.maxx.showroom.hibernate.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name="product")
@Table(name="product")
public class ProductEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="productId")
	int productId;
	
	@ManyToOne(targetEntity = BrandEntity.class)
	@JoinColumn(name="brandId")
	BrandEntity brandEntity;
	
	@Column(name="productName")
	String productName;
	
	@Column(name="category")
	String category;
	
	@Column(name="cost")
	String cost;
	
	
	public ProductEntity() {
		
		
	}


	public ProductEntity(int productId, String productName, String category, String cost) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.category = category;
		this.cost = cost;
	}


	public int getProductId() {
		return productId;
	}


	public void setProductId(int productId) {
		this.productId = productId;
	}

	public BrandEntity getBrandEntity() {
		return brandEntity;
	}


	public void setBrandEntity(BrandEntity brandEntity) {
		this.brandEntity = brandEntity;
	}


	public String getProductName() {
		return productName;
	}


	public void setProductName(String productName) {
		this.productName = productName;
	}


	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}


	public String getCost() {
		return cost;
	}


	public void setCost(String cost) {
		this.cost = cost;
	}
	
	
	
}
