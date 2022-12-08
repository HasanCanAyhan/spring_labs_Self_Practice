package com.cydeo.lab08rest.service;

import com.cydeo.lab08rest.dto.CartDto;

public interface CartService {

    CartDto findById(Long id);

}
