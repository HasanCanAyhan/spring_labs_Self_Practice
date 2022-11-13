package com.cydeo.repository;

import com.cydeo.entity.Address;
import com.cydeo.entity.Discount;
import com.cydeo.enums.DiscountType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Repository
public interface DiscountRepository extends JpaRepository<Discount,Long> {
    //Write a derived query to get discount by name
    Optional<Discount> findByName(String name);

    //Write a derived query to get all discounts greater than discount amount

    List<Discount> findAllByDiscountGreaterThan(BigDecimal discount);

    //Write a derived query to get all discounts by specific discount type

    List<Discount> findAllByDiscountType(DiscountType discountType);

    //Write a JPQL query to get all discounts amount between range of discount amount

    @Query("select d from Discount d where d.discount between ?1 and ?2")
    List<Discount> getAllByAmountBetween(BigDecimal startAmount,BigDecimal endAmount);

}
