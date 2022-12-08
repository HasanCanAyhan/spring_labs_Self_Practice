package com.cydeo.lab08rest.service.impl;

import com.cydeo.lab08rest.dto.CartDto;
import com.cydeo.lab08rest.entity.Cart;
import com.cydeo.lab08rest.mapper.MapperUtil;
import com.cydeo.lab08rest.repository.CartRepository;
import com.cydeo.lab08rest.service.CartService;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl implements CartService {

    private final CartRepository cartRepository;
    private final MapperUtil mapperUtil;

    public CartServiceImpl(CartRepository cartRepository, MapperUtil mapperUtil) {
        this.cartRepository = cartRepository;
        this.mapperUtil = mapperUtil;
    }

    @Override
    public CartDto findById(Long id) {
        Cart cart = cartRepository.findById(id).orElseThrow();
        return mapperUtil.convert(cart,new CartDto());
    }
}
