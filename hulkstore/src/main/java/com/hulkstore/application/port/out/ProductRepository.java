package com.hulkstore.application.port.out;

import com.hulkstore.domain.model.Product;

import java.util.Optional;

public interface ProductRepository {
    Optional<Product> findById(Long id);
    Product save(Product product);
    void delete(Product product);
}

