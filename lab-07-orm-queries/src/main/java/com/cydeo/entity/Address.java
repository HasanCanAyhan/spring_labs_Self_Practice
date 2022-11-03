package com.cydeo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

@Entity
@Data
@NoArgsConstructor
public class Address extends BaseEntity {

    private String name;
    private String street;
    private String zipCode;

    @ManyToOne
    private Customer customer;



}
