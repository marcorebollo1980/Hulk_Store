package com.hulkstorea.application.service;

import com.hulkstore.application.port.out.ProductRepository;
import com.hulkstore.domain.model.Product;
import org.springframework.stereotype.Service;

@Service
public class ProductService implements com.hulkstorea.application.port.in.AddProductUseCase, com.hulkstorea.application.port.in.RemoveProductUseCase {
    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository2) {
		// TODO Auto-generated constructor stub
	}

	@Override
    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void removeProduct(Long id) {
        productRepository.findById(id).ifPresent(product -> {
            if (product.getQuantity() > 0) {
                product.setQuantity(product.getQuantity() - 1);
                productRepository.save(product);
            } else {
                throw new IllegalStateException("No stock available");
            }
        });
    }
}