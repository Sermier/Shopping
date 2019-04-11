package com.webstore.domain.repository;

import com.webstore.domain.Product;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface ProductRepository {
	List<Product> getAllProducts();
	List<Product> getProductsByCategory(String category);
	Product getProductById(String productid);
	Set<Product> getProductsByFiler(Map<String, List<String>> filterParams);
	void addProduct(Product product);
}
