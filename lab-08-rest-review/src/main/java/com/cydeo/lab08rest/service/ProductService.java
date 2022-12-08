package com.cydeo.lab08rest.service;

import com.cydeo.lab08rest.dto.ProductDTO;

import java.util.List;

public interface ProductService {
    List<ProductDTO> retrieveListProducts();
}
