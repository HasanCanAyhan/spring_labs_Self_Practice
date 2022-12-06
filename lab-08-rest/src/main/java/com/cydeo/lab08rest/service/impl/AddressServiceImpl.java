package com.cydeo.lab08rest.service.impl;

import com.cydeo.lab08rest.dto.AddressDTO;
import com.cydeo.lab08rest.entity.Address;
import com.cydeo.lab08rest.mapper.MapperUtil;
import com.cydeo.lab08rest.repository.AddressRepository;
import com.cydeo.lab08rest.service.AddressService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;
    private final MapperUtil mapperUtil;

    public AddressServiceImpl(AddressRepository addressRepository, MapperUtil mapperUtil) {
        this.addressRepository = addressRepository;
        this.mapperUtil = mapperUtil;
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
        return null;
    }

    @Override
    public List<AddressDTO> getAddressListByCustomerId(Long customerId) {
        return null;
    }

    @Override
    public List<AddressDTO> getAddressListByCustomerAndName(Long customerId, String addressName) {
        return null;
    }
}
