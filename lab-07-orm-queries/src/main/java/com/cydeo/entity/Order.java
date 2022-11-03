package com.cydeo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Data
@NoArgsConstructor
@Table(name = "orders")
public class Order extends BaseEntity {

    private BigDecimal paidPrice;
    private BigDecimal totalPrice;

    @OneToOne(fetch = FetchType.LAZY)
    private Cart cart;

    @ManyToOne(fetch = FetchType.LAZY)
    private Customer customer;

    @OneToOne(fetch = FetchType.LAZY)
    private Payment payment;

}
