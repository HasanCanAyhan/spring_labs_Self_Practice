package com.cydeo.spring05thymeleaf.controller;


import com.cydeo.spring05thymeleaf.model.Product;
import com.cydeo.spring05thymeleaf.repository.ProductRepository;
import com.cydeo.spring05thymeleaf.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProductController {

   private final ProductService productService;
   private final ProductRepository productRepository;


    public ProductController(ProductService productService, ProductRepository productRepository) {
        this.productService = productService;
        this.productRepository = productRepository;
    }



    @GetMapping("/create-form")
    public String createProduct(Model model ){

        model.addAttribute("product",new Product());


        return "product/create-product";
    }

    @PostMapping("/create-product")
    public String createProduct(@ModelAttribute("product") Product product, Model model) {
        productService.productCreate(product);
        productRepository.save(product);
        model.addAttribute("productList", productRepository.findAll());

        return "redirect:/list";
    }


    @GetMapping("/list")
    public String showList(Model model) {

        model.addAttribute("productList",productService.listProduct());

        return "product/list";
    }





}
