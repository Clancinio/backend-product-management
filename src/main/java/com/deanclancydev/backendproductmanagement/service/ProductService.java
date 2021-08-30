package com.deanclancydev.backendproductmanagement.service;

import com.deanclancydev.backendproductmanagement.dto.Product;

import java.util.List;

public interface ProductService {

    Product saveProduct(final Product product);

    Product updateProduct(final Product product);

    void deleteProduct(Long id);

    List<Product> findAllProducts();

    String numberOfProducts();
}
