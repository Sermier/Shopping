package com.webstore.service.impl;

import com.webstore.domain.Product;
import com.webstore.domain.repository.ProductRepository;
import com.webstore.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService{

	@Autowired
	@Qualifier("OutMemory")
	private ProductRepository productRepository;

	public void processOrder(String productId, long quantity) {
		Product productById = productRepository.getProductById(productId);

		if(productById.getUnitsInStock() < quantity){
			throw new IllegalArgumentException("Out of stock. Available units in stock is "+ productById.getUnitsInStock());
		}
		productById.setUnitsInStock(productById.getUnitsInStock()-quantity);
	}
}
