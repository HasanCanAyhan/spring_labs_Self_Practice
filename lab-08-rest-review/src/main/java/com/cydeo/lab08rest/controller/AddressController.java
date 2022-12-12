package com.cydeo.lab08rest.controller;


import com.cydeo.lab08rest.dto.AddressDTO;
import com.cydeo.lab08rest.dto.CustomerDTO;
import com.cydeo.lab08rest.model.ResponseWrapper;
import com.cydeo.lab08rest.service.AddressService;
import com.cydeo.lab08rest.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/address")
public class AddressController {

    private final AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }


    @GetMapping
    public ResponseEntity<ResponseWrapper> listAllAddresses(){
        List<AddressDTO> addressDTOList = addressService.readAll();

        return ResponseEntity.ok(new ResponseWrapper("Addresses are retrieved",
                addressDTOList, HttpStatus.OK));

    }

    @PutMapping
    public ResponseEntity<ResponseWrapper> updateAddress(@RequestBody AddressDTO addressDTO){


        return ResponseEntity.ok(new ResponseWrapper("Addresses is updated",
                addressService.update(addressDTO), HttpStatus.OK));
    }


    @PostMapping
    public ResponseEntity<ResponseWrapper> createAddress(@RequestBody AddressDTO addressDTO){

        return ResponseEntity.ok(new ResponseWrapper("Addresses is created",
                addressService.create(addressDTO), HttpStatus.OK));
    }


    @GetMapping("/startsWith/{address}")
    public ResponseEntity<ResponseWrapper> getAddressByStartsWith(@PathVariable("address") String address){
        return ResponseEntity.ok(new ResponseWrapper("Addresses are retrieved",
                addressService.readByStartsWith(address), HttpStatus.OK));
    }


    @GetMapping("/customer/{id}")
    public ResponseEntity<ResponseWrapper> getAddressByCustomerId(@PathVariable("id") Long id){
        return ResponseEntity.ok(new ResponseWrapper("Addresses are retrieved",
                addressService.readAllByCustomerId(id), HttpStatus.OK));
    }

    @GetMapping("/customer/{customerId}/name/{name}")
    public ResponseEntity<ResponseWrapper> getAddressByCustomerId(@PathVariable("customerId") Long customerId,@PathVariable("name") String name){
        return ResponseEntity.ok(new ResponseWrapper("Addresses are retrieved",
                addressService.readAllByCustomerIdAndName(customerId,name), HttpStatus.OK));
    }



}
