package com.hulkstorea.adapter.out.memory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.hulkstore.application.port.out.ProductRepository;
import com.hulkstorea.application.service.ProductService;

@SpringBootApplication
public class HulkstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(HulkstoreApplication.class, args);
	}
	
	 @Bean
	 public ProductRepository productRepository() {
	     return new MemoryProductRepository();
	 }

	 @Bean
	 public ProductService productService(ProductRepository productRepository) {
	    return new ProductService(productRepository);
	 }

}
