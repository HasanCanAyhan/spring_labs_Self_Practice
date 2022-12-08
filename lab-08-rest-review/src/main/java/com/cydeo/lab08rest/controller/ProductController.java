package com.cydeo.lab08rest.controller;

import com.cydeo.lab08rest.dto.ProductDTO;
import com.cydeo.lab08rest.dto.ProductRequest;
import com.cydeo.lab08rest.model.ResponseWrapper;
import com.cydeo.lab08rest.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {

    /*
    you can use for to reformat pages it will automatically remove unnecessary imports ctrl + alt + L
     */

    private final ProductService productService;


    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<ResponseWrapper> listProducts() {

        return ResponseEntity.ok(new ResponseWrapper("Products are successfully retrieved", productService.retrieveListProducts(), HttpStatus.OK));
    }

    @PutMapping
    public ResponseEntity<ResponseWrapper> updateProduct(@RequestBody ProductDTO productDTO) {//we bind json to productDTO using @RequestBody

        return ResponseEntity.ok(new ResponseWrapper("Product is successfully updated", productService.updateProduct(productDTO), HttpStatus.OK));

    }

    @PostMapping
    public ResponseEntity<ResponseWrapper> createProduct(@RequestBody ProductDTO productDTO) {//we bind json to productDTO using @RequestBody

        return ResponseEntity.ok(new ResponseWrapper("Product is successfully created", productService.createProduct(productDTO), HttpStatus.OK));
    }

    @PostMapping("/categoryandprice")
    public ResponseEntity<ResponseWrapper> retrieveProductByCategoryAndPrice(@RequestBody ProductRequest productRequest) {//we bind json to productDTO using @RequestBody

        return ResponseEntity
                .ok(new ResponseWrapper("Product is successfully retrieved", productService.retrieveProductByCategoryAndPrice(productRequest.getCategoryList(), productRequest.getPrice()), HttpStatus.OK));
    }

    @GetMapping("/{name}")
    public ResponseEntity<ResponseWrapper> retrieveProductListByName(@PathVariable("name") String name) {
        return ResponseEntity.ok(new ResponseWrapper("Product are successfully retrieved", productService.retrieveByName(name), HttpStatus.OK));
    }


    @GetMapping("/top3")
    public ResponseEntity<ResponseWrapper> retrieveProductByTop3ProductByPrice(){
        return ResponseEntity.ok(new ResponseWrapper("Product are successfully retrieved", productService.retrieveProductByTop3ProductByPrice(), HttpStatus.OK));
    }

    @GetMapping("/price/{price}")
    public ResponseEntity<ResponseWrapper> countProductByPrice(@PathVariable BigDecimal price){
        return ResponseEntity.ok(new ResponseWrapper("Product are successfully retrieved", productService.countProductByPrice(price), HttpStatus.OK));

    }

    @GetMapping("/price/{price}/quantity/{quantity}")
    public ResponseEntity<ResponseWrapper> retrieveProductByPriceAndByQuantity(@PathVariable BigDecimal price,@PathVariable Integer quantity){
        return ResponseEntity.ok(new ResponseWrapper("Product are successfully retrieved", productService.retrieveProductByPriceAndByQuantity(price,quantity), HttpStatus.OK));

    }

    @GetMapping("/category/{id}")
    public ResponseEntity<ResponseWrapper> retrieveProductCategoryById(@PathVariable("id") Long id ){
        return ResponseEntity.ok(new ResponseWrapper("Product are successfully retrieved", productService
                .retrieveProductByCategory(id), HttpStatus.OK));

    }




}
