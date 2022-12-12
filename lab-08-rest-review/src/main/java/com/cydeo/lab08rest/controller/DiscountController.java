package com.cydeo.lab08rest.controller;

import com.cydeo.lab08rest.dto.DiscountDTO;
import com.cydeo.lab08rest.model.ResponseWrapper;
import com.cydeo.lab08rest.service.DiscountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/discount")
public class DiscountController {

    private final DiscountService discountService;

    public DiscountController(DiscountService discountService) {
        this.discountService = discountService;
    }


    @GetMapping
    public ResponseEntity<ResponseWrapper> listAllDiscounts(){
        List<DiscountDTO> discountDTOList = discountService.readAll();

        return ResponseEntity.ok(new ResponseWrapper("Discounts are retrieved",
                discountDTOList, HttpStatus.OK));

    }

    @PutMapping
    public ResponseEntity<ResponseWrapper> updateDiscount(@RequestBody DiscountDTO discountDTO){

        DiscountDTO update = discountService.update(discountDTO);
        return ResponseEntity.ok(new ResponseWrapper("Discount is updated",
                update, HttpStatus.OK));
    }


    @PostMapping
    public ResponseEntity<ResponseWrapper> createDiscount(@RequestBody DiscountDTO discountDTO){

        return ResponseEntity.ok(new ResponseWrapper("Discount is created",
                discountService.create(discountDTO), HttpStatus.OK));
    }


    @GetMapping("/{name}")
    public ResponseEntity<ResponseWrapper> getDiscountByName(@PathVariable("name") String name){
        return ResponseEntity.ok(new ResponseWrapper("Discount is retrieved",
                discountService.readByName(name), HttpStatus.OK));
    }




}
