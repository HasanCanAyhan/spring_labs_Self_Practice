package com.cydeo.lab08rest.service.impl;

import com.cydeo.lab08rest.dto.ProductDTO;
import com.cydeo.lab08rest.dto.ProductRequest;
import com.cydeo.lab08rest.entity.Category;
import com.cydeo.lab08rest.entity.Product;
import com.cydeo.lab08rest.mapper.MapperUtil;
import com.cydeo.lab08rest.repository.ProductRepository;
import com.cydeo.lab08rest.service.ProductService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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
    public ProductDTO save(ProductDTO productDTO) {

        productRepository.save(mapperUtil.convert(productDTO, new Product()));
        return productDTO;
    }

    @Override
    public List<ProductDTO> getProductList() {
        List<Product> productList = productRepository.findAll();
        return productList.stream().map(product -> mapperUtil.convert(product, new ProductDTO())).collect(Collectors.toList());
    }

    @Override
    public ProductDTO getProductByName(String name) {
        Product product = productRepository.findFirstByName(name);
        return mapperUtil.convert(product, new ProductDTO());
    }

    @Override
    public List<ProductDTO> getTop3ProductList() {

        List<Product> productList = productRepository.findTop3ByOrderByPriceDesc();
        return productList.stream().map(product -> mapperUtil.convert(product, new ProductDTO())).collect(Collectors.toList());
    }

    @Override
    public Integer getProductListByPrice(BigDecimal price) {
        Integer count = productRepository.countProductByPriceGreaterThan(price);
        return count;
    }

    @Override
    public List<ProductDTO> getProductListByPriceAndQuantity(BigDecimal price, Integer quantity) {

        List<Product> productList = productRepository.retrieveProductListGreaterThanPriceAndLowerThanRemainingQuantity(price, quantity);

        return productList.stream().map(product -> mapperUtil.convert(product, new ProductDTO())).collect(Collectors.toList());
    }

    @Override
    public List<ProductDTO> getProductListByCategory(Long id) {

        List<Product> productList = productRepository.retrieveProductListByCategory(id);

        return productList.stream().map(product -> mapperUtil.convert(product, new ProductDTO())).collect(Collectors.toList());
    }

    @Override
    public ProductDTO update(ProductDTO productDTO) {

        Product product = productRepository.findById(productDTO.getId()).orElseThrow();
        product.setName(productDTO.getName());
        product.setQuantity(productDTO.getQuantity());
        product.setRemainingQuantity(productDTO.getRemainingQuantity());
        product.setPrice(productDTO.getPrice());

        productRepository.save(product);

        return mapperUtil.convert(product, new ProductDTO());


    }

    @Override
    public List<ProductDTO> getProductRequest(ProductRequest productRequest) {

        List<Product> productList = productRepository.retrieveProductListByCategory(productRequest.getCategoryList(), productRequest.getPrice());
        return productList.stream().map(product -> mapperUtil.convert(product, new ProductDTO())).collect(Collectors.toList());

    }


}
