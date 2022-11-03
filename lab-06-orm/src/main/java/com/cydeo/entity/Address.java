package com.cydeo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Address extends BaseEntity{

    private String name;
    private String street;
    private String zipCode;

    @ManyToOne(fetch = FetchType.LAZY)
    private Customer customer;



}
