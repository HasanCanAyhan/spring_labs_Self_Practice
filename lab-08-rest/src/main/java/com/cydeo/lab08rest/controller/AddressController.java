package com.cydeo.lab08rest.controller;

import com.cydeo.lab08rest.dto.AddressDTO;
import com.cydeo.lab08rest.model.ResponseWrapper;
import com.cydeo.lab08rest.service.AddressService;
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
    public ResponseEntity<ResponseWrapper> getAddressList() {

        return ResponseEntity.ok(new ResponseWrapper("Address are successfully retrieved", addressService.getAddressList(), HttpStatus.ACCEPTED));
    }

    @PostMapping
    public ResponseEntity<ResponseWrapper> createAddress(@RequestBody AddressDTO addressDTO) {

        return ResponseEntity.ok(new ResponseWrapper("Address is successfully created", addressService.save(addressDTO), HttpStatus.CREATED));

    }

    @PutMapping()
    public ResponseEntity<ResponseWrapper> updateAddress(@RequestBody AddressDTO addressDTO) {

        return ResponseEntity.ok(new ResponseWrapper("Address is successfully updated", addressService.update(addressDTO), HttpStatus.CREATED));


    }


    @GetMapping("/startsWith/{address}")
    public ResponseEntity<ResponseWrapper> getAddressListByStartsWithAddress(@PathVariable("address") String address){
        List<AddressDTO> addressDTOS = addressService.getAddressListByStartsWithAddress(address);
        return ResponseEntity.ok(new ResponseWrapper("Addresses are successfully retrieved", addressDTOS, HttpStatus.OK));

    }

    @GetMapping("/customer/{id}")
    public ResponseEntity<ResponseWrapper> getAddressListByCustomerId(@PathVariable("id") Long id){

        List<AddressDTO> addressDTOList = addressService.getAddressListByCustomerId(id);

        return ResponseEntity.ok(new ResponseWrapper("Addresses are successfully retrieved", addressDTOList, HttpStatus.OK));


    }

    @GetMapping("/customer/{customerId}/name/{name}")
    public ResponseEntity<ResponseWrapper> getAddressListByCustomerAndName(@PathVariable("customerId") Long customerId,@PathVariable("name") String addressName){

        List<AddressDTO> addressDTOS = addressService.getAddressListByCustomerAndName(customerId, addressName);
        return ResponseEntity.ok(new ResponseWrapper("Addresses are successfully retrieved", addressDTOS, HttpStatus.OK));

    }





}
