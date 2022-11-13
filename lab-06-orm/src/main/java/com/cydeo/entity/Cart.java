package com.cydeo.entity;

import com.cydeo.enums.CartState;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Cart extends BaseEntity{

    @Enumerated(EnumType.STRING)
    private CartState cartState;

    @ManyToOne//(fetch = FetchType.LAZY)
    private Customer customer;

    @ManyToOne//(fetch = FetchType.LAZY)
    private Discount discount;



}
