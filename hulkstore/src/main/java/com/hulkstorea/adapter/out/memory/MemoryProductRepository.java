// src/main/java/com/hulkstore/adapter/out/memory/MemoryProductRepository.java
package com.hulkstorea.adapter.out.memory;

import com.hulkstore.application.port.out.ProductRepository;
import com.hulkstore.domain.model.Product;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Repository
public class MemoryProductRepository implements ProductRepository {
    private final Map<Long, Product> productStore = new HashMap<>();

    @Override
    public Optional<Product> findById(Long id) {
        return Optional.ofNullable(productStore.get(id));
    }

    @Override
    public Product save(Product product) {
        productStore.put(product.getId(), product);
        return product;
    }

    @Override
    public void delete(Product product) {
        productStore.remove(product.getId());
    }
}
