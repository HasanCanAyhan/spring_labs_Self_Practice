package com.cydeo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import java.math.BigDecimal;

@Entity
@Data
@NoArgsConstructor
public class Balance extends BaseEntity{

    private BigDecimal amount;

    @OneToOne(fetch = FetchType.LAZY)
    private Customer customer;




}
