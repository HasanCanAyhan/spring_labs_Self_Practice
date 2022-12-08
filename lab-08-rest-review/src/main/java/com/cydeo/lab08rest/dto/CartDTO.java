package com.cydeo.lab08rest.dto;

import com.cydeo.lab08rest.entity.Customer;
import com.cydeo.lab08rest.entity.Discount;
import com.cydeo.lab08rest.enums.CartState;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class CartDTO {

    private Customer customer;

    private Discount discount;

    private CartState cartState;
}
