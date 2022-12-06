package com.cydeo.lab08rest.service.impl;

import com.cydeo.lab08rest.dto.AddressDTO;
import com.cydeo.lab08rest.dto.CustomerDTO;
import com.cydeo.lab08rest.entity.Address;
import com.cydeo.lab08rest.entity.Customer;
import com.cydeo.lab08rest.mapper.MapperUtil;
import com.cydeo.lab08rest.repository.AddressRepository;
import com.cydeo.lab08rest.service.AddressService;
import com.cydeo.lab08rest.service.CustomerService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;
    private final MapperUtil mapperUtil;

    private final CustomerService customerService;

    public AddressServiceImpl(AddressRepository addressRepository, MapperUtil mapperUtil, CustomerService customerService) {
        this.addressRepository = addressRepository;
        this.mapperUtil = mapperUtil;
        this.customerService = customerService;
    }


    @Override
    public List<AddressDTO> getAddressList() {

        List<Address> addresses = addressRepository.findAll();

        return addresses.stream()
                .map(address -> mapperUtil.convert(address, new AddressDTO()))
                .collect(Collectors.toList());

    }

    @Override
    public AddressDTO save(AddressDTO addressDTO) {

        Address address = mapperUtil.convert(addressDTO, new Address());
        addressRepository.save(address);
        return addressDTO;
    }

    @Override
    public AddressDTO update(AddressDTO addressDTO) {

        Address address = addressRepository.findById(addressDTO.getId()).orElseThrow();

        address.setName(addressDTO.getName());
        address.setStreet(addressDTO.getStreet());
        address.setZipCode(addressDTO.getZipCode());

        address.setCustomer(address.getCustomer());


        addressRepository.save(address);

        return mapperUtil.convert(address,new AddressDTO());

    }

    @Override
    public List<AddressDTO> getAddressListByStartsWithAddress(String address) {

        List<Address> addressList = addressRepository.findAllByStreetStartingWith(address);
        return addressList.stream()
                .map(address1 -> mapperUtil.convert(address1,new AddressDTO()))
                .collect(Collectors.toList());

    }

    @Override
    public List<AddressDTO> getAddressListByCustomerId(Long customerId) {

        List<Address> addresses = addressRepository.retrieveByCustomerId(customerId);
        return addresses.stream()
                .map(address1 -> mapperUtil.convert(address1,new AddressDTO()))
                .collect(Collectors.toList());
    }

    @Override
    public List<AddressDTO> getAddressListByCustomerAndName(Long customerId, String addressName) {

        CustomerDTO customerDTO = customerService.findById(customerId);

        Customer customer = mapperUtil.convert(customerDTO, new Customer());

        List<Address> addressList = addressRepository.findAllByCustomerAndName(customer, addressName);
        return addressList.stream()
                .map(address -> mapperUtil.convert(address,new AddressDTO()))
                .collect(Collectors.toList());
    }
}
