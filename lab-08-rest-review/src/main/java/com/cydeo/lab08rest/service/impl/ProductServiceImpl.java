package com.cydeo.lab08rest.service.impl;


import com.cydeo.lab08rest.dto.ProductDTO;
import com.cydeo.lab08rest.entity.Category;
import com.cydeo.lab08rest.entity.Product;
import com.cydeo.lab08rest.mapper.MapperUtil;
import com.cydeo.lab08rest.repository.ProductRepository;
import com.cydeo.lab08rest.service.CategoryService;
import com.cydeo.lab08rest.service.ProductService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final MapperUtil mapperUtil;


    public ProductServiceImpl(ProductRepository productRepository, MapperUtil mapperUtil) {
        this.productRepository = productRepository;
        this.mapperUtil = mapperUtil;
    }

    @Override
    public List<ProductDTO> retrieveListProducts() {
        List<Product> productList = productRepository.findAll();
        return  productList.stream()
                .map(product -> mapperUtil.convert(product,new ProductDTO()))
                .collect(Collectors.toList());
    }

    @Override
    public ProductDTO updateProduct(ProductDTO productDTO) {

        Product product = productRepository.save(mapperUtil.convert(productDTO, new Product()));
        //If the id is the same, save method of jpa repo works as updating


        return mapperUtil.convert(product, new ProductDTO());

    }

    @Override
    public ProductDTO createProduct(ProductDTO productDTO) {
        Product product = productRepository.save(mapperUtil.convert(productDTO, new Product()));
        //If the id is the same, save method of jpa repo works as updating
        return mapperUtil.convert(product, new ProductDTO());
    }

    @Override
    public List<ProductDTO> retrieveProductByCategoryAndPrice(List<Long> categoryList, BigDecimal price) {
        List<Product> productList = productRepository.retrieveProductListByCategory(categoryList, price);
        return  productList.stream()
                .map(product -> mapperUtil.convert(product,new ProductDTO()))
                .collect(Collectors.toList());
    }

    @Override
    public ProductDTO retrieveByName(String name) {
        Product product = productRepository.findFirstByName(name);
        return mapperUtil.convert(product,new ProductDTO());

    }

    @Override
    public List<ProductDTO> retrieveProductByTop3ProductByPrice() {
        return productRepository.findTop3ByOrderByPriceDesc().stream()
                .map(product -> mapperUtil.convert(product,new ProductDTO())).collect(Collectors.toList());
    }

    @Override
    public Integer countProductByPrice(BigDecimal price) {
        return productRepository.countProductByPriceGreaterThan(price);
    }

    @Override
    public List<ProductDTO> retrieveProductByPriceAndByQuantity(BigDecimal price, Integer quantity) {
      return productRepository.retrieveProductListGreaterThanPriceAndLowerThanRemainingQuantity(price, quantity)
                .stream()
                .map(product -> mapperUtil.convert(product, new ProductDTO()))
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductDTO> retrieveProductByCategory(Long id) {

        List<Product> list = productRepository.retrieveProductListByCategory(id);
        return list.stream()
                .map(product -> mapperUtil.convert(product, new ProductDTO()))
                .collect(Collectors.toList());
    }


}
