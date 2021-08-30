package com.deanclancydev.backendproductmanagement.service.impl;

import com.deanclancydev.backendproductmanagement.dto.Product;
import com.deanclancydev.backendproductmanagement.entity.ProductEntity;
import com.deanclancydev.backendproductmanagement.exceptions.DBException;
import com.deanclancydev.backendproductmanagement.repository.ProductRepository;
import com.deanclancydev.backendproductmanagement.service.ProductService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

import static com.deanclancydev.backendproductmanagement.constants.ExceptionConstants.*;

@Log4j2
@Service
@Transactional
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    final private ProductRepository productRepository;

    final private ObjectMapper objectMapper;

    @Override
    public Product saveProduct(final Product product) {
        try {
            final ProductEntity productEntity = objectMapper.convertValue(product, ProductEntity.class);
            productRepository.save(productEntity);
            return product;
        } catch (final Exception exception) {
            log.error(exception);
            throw new DBException(SERVICE_SAVE_PRODUCT_EXCEPTION_MESSAGE, exception);
        }
    }

    @Override
    public Product updateProduct(Product product) {
        try {
            final ProductEntity productEntity = objectMapper.convertValue(product, ProductEntity.class);
            productRepository.save(productEntity);
            return product;
        } catch (final Exception exception) {
            log.error(exception);
            throw new DBException(SERVICE_UPDATE_PRODUCT_EXCEPTION_MESSAGE, exception);
        }
    }

    @Override
    public void deleteProduct(Long id) {
        try {
            productRepository.deleteById(id);
        } catch (final Exception exception) {
            log.error(exception);
            throw new DBException(SERVICE_DELETE_PRODUCT_EXCEPTION_MESSAGE, exception);
        }
    }

    @Override
    public List<Product> findAllProducts() {
        try {
            return productRepository.findAll().stream().map(productEntity -> objectMapper.convertValue(productEntity, Product.class))
                    .collect(Collectors.toList());
        } catch (final Exception exception) {
            log.error(exception);
            throw new DBException(SERVICE_FIND_ALL_PRODUCTS_EXCEPTION_MESSAGE, exception);
        }
    }

    @Override
    public String numberOfProducts() {
        long count = productRepository.count();
        return Long.toString(count);
    }
}
