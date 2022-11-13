package com.cydeo.entity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class CartItem extends BaseEntity{

    private Integer quantity;

    @ManyToOne//(fetch = FetchType.LAZY)
    private Product product;

    @ManyToOne//(fetch = FetchType.LAZY)
    private Cart cart;



}
