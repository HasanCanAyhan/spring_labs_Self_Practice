package com.cydeo.lab08rest.controller;


import com.cydeo.lab08rest.dto.ProductDTO;
import com.cydeo.lab08rest.model.ResponseWrapper;
import com.cydeo.lab08rest.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {

    private final ProductService productService;


    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    @GetMapping
    public ResponseEntity<ResponseWrapper> getProductList(){
        return ResponseEntity.ok(new ResponseWrapper("Products are successfully retrieved", productService.getProductList(), HttpStatus.OK));
    }


    @PostMapping
    public ResponseEntity<ResponseWrapper> createProduct(@RequestBody ProductDTO productDTO){
        ProductDTO productDTO1 = productService.save(productDTO);
        return ResponseEntity.ok(new ResponseWrapper("Product is successfully created",productDTO1, HttpStatus.OK));
    }

    @PostMapping("/categoryandprice")//??????????
    public ResponseEntity<ResponseWrapper> createCategoryAndPrice(@RequestBody ProductDTO productDTO) {



        return null;

    }


    @PutMapping
    public ResponseEntity<ResponseWrapper> updateProduct(@RequestBody ProductDTO productDTO) {

        ProductDTO updatedProduct = productService.update(productDTO);

        return ResponseEntity.ok(new ResponseWrapper("Product is successfully updated",updatedProduct, HttpStatus.OK));

    }




    @GetMapping("/{name}")
    public ResponseEntity<ResponseWrapper> getProductByName(@PathVariable("name") String name){

        ProductDTO productDTO = productService.getProductByName(name);
        return ResponseEntity.ok(new ResponseWrapper("Product is successfully retrieved",productDTO, HttpStatus.OK));

    }


    @GetMapping("/top3")
    public ResponseEntity<ResponseWrapper> getTop3ProductList(){

        List<ProductDTO> top3ProductList = productService.getTop3ProductList();
        return ResponseEntity.ok(new ResponseWrapper("Product is successfully retrieved",top3ProductList, HttpStatus.OK));

    }


    @GetMapping("/price/{price}")
    public ResponseEntity<ResponseWrapper> getProductListByPrice(@PathVariable("price") BigDecimal price){ // it is asking the count greater than specific price
        Integer count = productService.getProductListByPrice(price);
        return ResponseEntity.ok(new ResponseWrapper("Products are successfully retrieved",count, HttpStatus.OK));

    }

    //***
    @GetMapping("/price/{price}/quantity/{quantity}")// inside ProductControllerTest there is no api endpoint to test it.
    public ResponseEntity<ResponseWrapper> getProductListByPriceAndQuantity(@PathVariable("price") BigDecimal price, @PathVariable("quantity") Integer quantity){

        List<ProductDTO> productDTOS = productService.getProductListByPriceAndQuantity(price, quantity);

        return ResponseEntity.ok(new ResponseWrapper("Products are successfully retrieved",productDTOS, HttpStatus.OK));
    }


    @GetMapping("/category/{id}")
    public ResponseEntity<ResponseWrapper> getProductListByCategory(@PathVariable("id") Long  id){
        List<ProductDTO> productDTOList = productService.getProductListByCategory(id);

        return ResponseEntity.ok(new ResponseWrapper("Products are successfully retrieved",productDTOList, HttpStatus.OK));
    }




}
