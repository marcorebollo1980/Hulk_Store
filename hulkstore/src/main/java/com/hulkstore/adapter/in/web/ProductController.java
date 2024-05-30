// src/main/java/com/hulkstore/adapter/in/web/ProductController.java
package com.hulkstore.adapter.in.web;

import com.hulkstore.domain.model.Product;
import com.hulkstorea.application.port.in.AddProductUseCase;
import com.hulkstorea.application.port.in.RemoveProductUseCase;

import jakarta.annotation.Nonnull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Nonnull
@RequestMapping("/products")
public class ProductController {
    //private static final AddProductUseCase addProductUseCase = null;
    //private static final RemoveProductUseCase removeProductUseCase = null;
  
    
    @Autowired
    private AddProductUseCase addProductUseCase2;
    
    @Autowired
    private RemoveProductUseCase removeProductUseCase2;
    
    @PostMapping("/add")
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
    	Product productOne = new Product();
    	productOne.setId(product.getId());
    	productOne.setName(product.getName());
        return new ResponseEntity<>(addProductUseCase2.addProduct(productOne), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> removeProduct(@PathVariable Long id) {
    	removeProductUseCase2.removeProduct(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }	
    
}

