package com.cydeo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

@Entity
@Data
@NoArgsConstructor
public class CartItem extends BaseEntity {

    private Integer quantity;

    @ManyToOne
    private Product product;

    @ManyToOne
    private Cart cart;



}
