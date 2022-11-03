package com.cydeo.lab04springmvc.controller;

import com.cydeo.lab04springmvc.service.ProductService;
import com.cydeo.lab04springmvc.service.impl.ProductServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProductController {


    private final ProductService productService ; // DI

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping("/search-product/{productName}")
    public String getProduct(@PathVariable String productName, Model model){


            model.addAttribute("productList", productService.searchProduct(productName));


        return"product/product-list.html";
    }


}
