package com.samsung.product.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.samsung.product.entities.Product;

public interface ProductRepository extends JpaRepository<Product,Integer>{
	@Query(value="SELECT * FROM PRODUCT WHERE PRODUCT_ID = ?1 AND PRODUCT_NAME = ?2", nativeQuery = true)
	public List<Product> getProductsByIdAndName(int id, String name);
}
