package com.cydeo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import java.math.BigDecimal;

@Entity
@Data
@NoArgsConstructor
public class Orders extends BaseEntity{

    private BigDecimal paidPrice;
    private BigDecimal totalPrice;

    @OneToOne(fetch = FetchType.LAZY)
    private Cart cart;

    @ManyToOne(fetch = FetchType.LAZY)
    private Customer customer;

    @OneToOne(fetch = FetchType.LAZY)
    private Payment payment;

}
