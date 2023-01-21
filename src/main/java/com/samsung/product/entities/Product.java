package com.samsung.product.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;


@Entity
public class Product {
	
	@Id
	 
	private int product_ID;
	private String product_name;
	private String product_desc;
	private long product_price;
	public int getProduct_ID() {
		return product_ID;
	}
	public void setProduct_ID(int product_ID) {
		this.product_ID = product_ID;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public String getProduct_desc() {
		return product_desc;
	}
	public void setProduct_desc(String product_desc) {
		this.product_desc = product_desc;
	}
	public long getProduct_price() {
		return product_price;
	}
	public void setProduct_price(long product_price) {
		this.product_price = product_price;
	}
	public Product(int product_ID, String product_name, String product_desc, long product_price) {
		super();
		this.product_ID = product_ID;
		this.product_name = product_name;
		this.product_desc = product_desc;
		this.product_price = product_price;
	}
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Product [product_ID=" + product_ID + ", product_name=" + product_name + ", product_desc=" + product_desc
				+ ", product_price=" + product_price + "]";
	}
	
	

}
