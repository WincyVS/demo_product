package com.samsung.product.services;

import java.util.List;
import java.util.Optional;

import com.samsung.product.entities.Product;

public interface ProductService {
	public boolean saveProduct(Product prod);
	public List<Product> getProducts();
	public Optional<Product> getProducts(int id);
	public List<Product> getProductsByIdAndName(int id, String name);
	public boolean updateProduct(Integer id, Product prod);
	public boolean deleteProduct(int product_id);
}
