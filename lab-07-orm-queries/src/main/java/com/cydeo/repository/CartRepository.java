package com.cydeo.repository;
import com.cydeo.entity.Address;
import com.cydeo.entity.Cart;
import com.cydeo.enums.CartState;
import com.cydeo.enums.DiscountType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository  extends JpaRepository<Cart,Long> {
    //Write a derived query to get all cart by specific discount type
    List<Cart> findAllByDiscount_DiscountType(DiscountType discountType);
    //Write a JPQL query to get all cart by customer

    @Query("select c from Cart c where c.customer.id = ?1")
    List<Cart> fetchAllCartByCustomer(Long id);

    //Write a derived query to get all cart by customer and cart state

    List<Cart> findAllByCustomerIdAndCartState(Long id, CartState cartState);

    //Write a derived query to get all cart by customer and cart state and discount is null condition
    List<Cart> findAllByCustomerIdAndDiscountIsNull(Long id);

    //Write a native query to get all cart by customer and cart state and discount is not null condition

    @Query(value = "select * from cart\n" +
            "         join customer c on c.id = cart.customer_id\n" +
            "         where customer_id = ?1 and discount_id is null",nativeQuery = true)
    List<Cart> findAllByCustomerIdAndDiscountIsNullByUsingNativeQuery(Long id);



}
