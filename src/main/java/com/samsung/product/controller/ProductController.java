 package com.samsung.product.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.samsung.product.entities.Product;
import com.samsung.product.services.ProductServiceImpl;

@RestController
@RequestMapping("/demo")
public class ProductController {

	@Autowired
	private ProductServiceImpl ps;
	
	@GetMapping("/products")
	public ResponseEntity<List<Product>> fetchProducts(){
		return new ResponseEntity<List<Product>>(ps.getProducts(), HttpStatus.OK);
	}
	
	@GetMapping("/products/{id}")
	public ResponseEntity<Optional<Product>> fetchProductByID(@PathVariable int id){
		Optional<Product> op = ps.getProducts(id);
		if(op.isEmpty()) {
			return new ResponseEntity<Optional<Product>>(op, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Optional<Product>>(op, HttpStatus.OK);
	}
	
	@GetMapping("/products/{id}/{name}")
	public List<Product> fetchProductByIdAndName(@PathVariable int id, @PathVariable String name){
		return ps.getProductsByIdAndName(id, name);
	}
	
	@PostMapping("/products")
	public ResponseEntity<String> postProduct(@RequestBody Product prod) {
		if (ps.saveProduct(prod)) {
			return new ResponseEntity<String>("Product saved successfully !", HttpStatus.CREATED);
		}
		return new ResponseEntity<String>("Product with same ID already exists!", HttpStatus.BAD_REQUEST);
	}
	
	@PutMapping("/product/{product_id}")
	public ResponseEntity<String> putProduct(@RequestBody Product prod, @PathVariable int product_id) {
		 if (ps.updateProduct(product_id,prod))
			 return  new ResponseEntity<String>("It exists !", HttpStatus.CREATED);
		 else
			 return new ResponseEntity<String>("Error", HttpStatus.NOT_FOUND);
	}
	@DeleteMapping("/product/{product_id}")
	public ResponseEntity<String> deleteProduct( @PathVariable int product_id) {
		 if (ps.deleteProduct(product_id))
			 return new ResponseEntity<String>("Product deleted successfully!.", HttpStatus.OK);
		 else
			 return new ResponseEntity<String>("Product not found!.", HttpStatus.NOT_FOUND);
	}
}
