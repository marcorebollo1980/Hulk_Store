package com.hulkstorea.application.port.in;

import com.hulkstore.domain.model.Product;

public interface AddProductUseCase {
    Product addProduct(Product product);
}
