package com.cydeo.repository;


import com.cydeo.entity.Address;
import com.cydeo.entity.CartItem;
import com.cydeo.entity.Discount;
import com.cydeo.enums.CartState;
import com.cydeo.enums.DiscountType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem,Long> {

    //Write a derived query to get count cart items
    Integer countAllBy();
    //Write a derived query to get cart items for specific cart state
    List<CartItem> findAllByCart_CartState(CartState cartState);
    //Write a native query to get cart items for specific cart state and product name
    @Query("select ci from CartItem ci where ci.cart.cartState = ?1 and ci.product.name = ?2")
    List<CartItem> fetchCartItemsByStateAndProductName(CartState cartState, String productName);

    //Write a native query to get cart items for specific cart state and without discount


    @Query(value = "select * from cart_item join cart c on c.id = cart_item.cart_id\n" +
            "where c.cart_state = ?1 and c.discount_id is null ", nativeQuery = true)
    List<CartItem> getCartItemsByCartStateWithoutDiscount(CartState cartState);

    //Write a native query to get cart items for specific cart state and with specific Discount type

    @Query(value = "\n" +
            "select * from cart_item join cart c on c.id = cart_item.cart_id\n" +
            "         join discount d on d.id = c.discount_id\n" +
            "where c.cart_state = ?1 and d.discount_type = ?2",nativeQuery = true)
    List<CartItem> fetchCartItemByCartStateAndDiscountType(CartState cartState, DiscountType discountType);

}
