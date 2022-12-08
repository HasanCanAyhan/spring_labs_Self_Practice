package com.cydeo.lab08rest.dto;

import com.cydeo.lab08rest.entity.BaseEntity;
import com.cydeo.lab08rest.entity.Customer;
import com.cydeo.lab08rest.entity.Discount;
import com.cydeo.lab08rest.enums.CartState;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;


@Getter
@Setter
public class CartDto {

    private Customer customer;

    private Discount discount;

    private CartState cartState;
}
