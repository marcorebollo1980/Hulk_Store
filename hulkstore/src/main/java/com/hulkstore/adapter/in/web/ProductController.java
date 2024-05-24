// src/main/java/com/hulkstore/adapter/in/web/ProductController.java
package com.hulkstore.adapter.in.web;

import com.hulkstore.domain.model.Product;
import com.hulkstorea.application.port.in.AddProductUseCase;
import com.hulkstorea.application.port.in.RemoveProductUseCase;

import jakarta.annotation.Nonnull;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Nonnull
@RequestMapping("/products")
public class ProductController {
    private static final AddProductUseCase addProductUseCase = null;
    private static final RemoveProductUseCase removeProductUseCase = null;

    @PostMapping("/add")
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        return new ResponseEntity<>(addProductUseCase.addProduct(product), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> removeProduct(@PathVariable Long id) {
        removeProductUseCase.removeProduct(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }	
    
}

