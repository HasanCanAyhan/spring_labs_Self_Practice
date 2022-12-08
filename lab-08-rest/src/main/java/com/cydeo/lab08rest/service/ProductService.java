package com.cydeo.lab08rest.service;

import com.cydeo.lab08rest.dto.ProductDTO;
import com.cydeo.lab08rest.dto.ProductRequest;
import com.cydeo.lab08rest.entity.Category;

import java.math.BigDecimal;
import java.util.List;

public interface ProductService {

    ProductDTO save(ProductDTO productDTO);

    List<ProductDTO> getProductList();

    ProductDTO getProductByName(String name);

    List<ProductDTO> getTop3ProductList();

    Integer getProductListByPrice(BigDecimal price);

    List<ProductDTO> getProductListByPriceAndQuantity(BigDecimal price, Integer quantity);

    List<ProductDTO> getProductListByCategory(Long id);

    ProductDTO update(ProductDTO productDTO);


    List<ProductDTO> getProductRequest(ProductRequest productRequest);
}
