package com.cydeo.entity;


import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Product extends BaseEntity{

    private String name;
    private BigDecimal price;
    private Integer quantity;
    private Integer remainingQuantity;

    /*
    @ManyToMany(mappedBy = "productList")
    private List<Category> categoryList;
     */

    @ManyToMany
    @JoinTable(name = "product_category_rel ",
            joinColumns = @JoinColumn(name = "p_id"),
            inverseJoinColumns = @JoinColumn(name = "c_id"))
    private List<Category> categoryList;
}
