package com.cydeo.repository;

import com.cydeo.entity.Address;
import com.cydeo.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
    //Write a derived query to get top 3 product order by price desc

    List<Product> findTop3ByOrderByPriceDesc();

    //Write a derived query to get product by specific name

    Optional<Product> findByName(String name);

    //Write a derived query to get product by specific category


    //Optional<Product> findByCategoryList(Long id);

    //Write a derived query to get count by price greater than specific amount

    Integer countAllByPriceGreaterThan(BigDecimal amount);


    //Write a derived query to get all product by quantity greater than or equal specific count

    List<Product> findAllByQuantityGreaterThanEqual(Integer quantity);

    //Write a native query to get all product by price greater than specific amount and quantity lower than specific count

    @Query(value = "select * from product where price > ?1 and quantity < ?2",nativeQuery = true)
    List<Product> fetchAllProductsBasedOnSpecificAmountAndQuantity(BigDecimal price, Integer quantity);


    //Write a native query to get all product by specific categoryId

    @Query(value = "select * from product join product_category_rel pcr on product.id = pcr.p_id\n" +
            "where c_id = ?1;",nativeQuery = true)
    List<Product> fetchAllProductsByCategoryId(Long id);

    //Write a native query to get all product by specific categoryId and price greater than specific amount

    @Query(value = "select * from product join product_category_rel pcr on product.id = pcr.p_id\n" +
            "where c_id = ?! and price > ?",nativeQuery = true)
    List<Product> fetchAllProductsByCategoryIdAndPrice(Long id,BigDecimal price);


}
