package com.cydeo.lab08rest.service.impl;

import com.cydeo.lab08rest.dto.CustomerDTO;
import com.cydeo.lab08rest.entity.Customer;
import com.cydeo.lab08rest.mapper.MapperUtil;
import com.cydeo.lab08rest.repository.CustomerRepository;
import com.cydeo.lab08rest.service.CustomerService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final MapperUtil mapperUtil;

    public CustomerServiceImpl(CustomerRepository customerRepository, MapperUtil mapperUtil) {
        this.customerRepository = customerRepository;
        this.mapperUtil = mapperUtil;
    }

    @Override
    public CustomerDTO findById(Long id) {
        Customer customer = customerRepository.findById(id).orElseThrow();
        return mapperUtil.convert(customer,new CustomerDTO());
    }

    @Override
    public List<CustomerDTO> getCustomerList() {
        List<Customer> customers = customerRepository.findAll();
        return customers.stream().map(customer -> mapperUtil.convert(customer,new CustomerDTO())).collect(Collectors.toList());
    }

    @Override
    public void save(CustomerDTO customerDTO) {

        customerRepository.save(mapperUtil.convert(customerDTO,new Customer()));
    }

    @Override
    public void update(CustomerDTO customerDTO) {

        Customer customer = customerRepository.findById(customerDTO.getId()).orElseThrow();
        customer.setEmail(customerDTO.getEmail());
        customer.setFirstName(customerDTO.getFirstName());
        customer.setUserName(customerDTO.getUserName());
        customer.setLastName(customerDTO.getLastName());

        customerRepository.save(customer);
    }

    @Override
    public CustomerDTO retrieveByCustomerEmail(String email) {

        Customer customer = customerRepository.retrieveByCustomerEmail(email);

        return mapperUtil.convert(customer, new CustomerDTO());

    }
}
