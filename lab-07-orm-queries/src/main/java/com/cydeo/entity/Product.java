package com.cydeo.entity;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Product extends BaseEntity {

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
