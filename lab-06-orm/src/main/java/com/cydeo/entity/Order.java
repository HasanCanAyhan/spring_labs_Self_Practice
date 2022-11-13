package com.cydeo.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "orders")
public class Order extends BaseEntity{

    private BigDecimal paidPrice;
    private BigDecimal totalPrice;

    @OneToOne//(fetch = FetchType.LAZY)
    private Cart cart;

    @ManyToOne//(fetch = FetchType.LAZY)
    private Customer customer;

    @OneToOne//(fetch = FetchType.LAZY)
    private Payment payment;

}
