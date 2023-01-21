package com.samsung.product.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.samsung.product.dao.ProductRepository;
import com.samsung.product.entities.Product;
import com.samsung.product.exception.ProductNotFoundException;

@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductRepository pr;
	
	public boolean saveProduct(Product prod) {
		boolean returnValue = false;
		if (!pr.existsById(prod.getProduct_ID())) {
			pr.save(prod);
			returnValue = true;
		} else {
			returnValue = false;
		}
		return returnValue;
	}

	public List<Product> getProducts(){
		return pr.findAll();
	}
	
	public Optional<Product> getProducts(int id) {
		 return pr.findById(id);
	}
	
	public List<Product> getProductsByIdAndName(int id, String name) {
		return pr.getProductsByIdAndName(id, name);
	}
	
	public boolean updateProduct(Integer id, Product prod) {
		boolean returnValue = false;
		if (pr.existsById(id)) {
			// Update
			returnValue = true;
			pr.save(prod);
		} else {
			returnValue = false;
		}
		return returnValue;
	}

	@Override
	public boolean deleteProduct(int id) {
		boolean returnValue = false;
		if (pr.existsById(id)) {
			// Update
			returnValue = true;
			pr.deleteById(id);
		} else {
			returnValue = false;
			try {
			throw new ProductNotFoundException("Product not found");
			} catch (Exception e) {
				System.out.print(e);
			}
		}
		return returnValue;
	}
}
