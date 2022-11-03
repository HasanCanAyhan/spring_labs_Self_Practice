package com.cydeo.spring05thymeleaf.service.impl;


import com.cydeo.spring05thymeleaf.model.Product;
import com.cydeo.spring05thymeleaf.repository.ProductRepository;
import com.cydeo.spring05thymeleaf.repository.impl.ProductRepositoryImpl;
import com.cydeo.spring05thymeleaf.service.ProductService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    @Override
    public boolean productCreate(Product product){
        // todo implement method

        product.setId(UUID.randomUUID());
        return true;
    }

    @Override
    public List<Product> listProduct() {
        // todo implement method
       return productRepository.findAll();
       // return new ArrayList<>();
    }

    @Override
    public Product findProductById(UUID uuid){
        return productRepository.findProductById(uuid);
        // todo implement method
        //return new Product();
    }

}
