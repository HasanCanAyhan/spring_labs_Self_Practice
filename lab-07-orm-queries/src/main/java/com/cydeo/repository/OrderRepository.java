package com.cydeo.repository;

import com.cydeo.entity.Address;
import com.cydeo.entity.Order;
import com.cydeo.enums.PaymentMethod;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;


@Repository
public interface OrderRepository extends JpaRepository<Order,Long> {
    //Write a derived query to get top 5 orders by order by total price desc

    List<Order> findTop5ByOrderByTotalPriceDesc();

    //Write a derived query to get all orders by customer email

    List<Order> findAllByCustomer_Email(String email);

    //Write a derived query to get all orders by specific payment method

    List<Order> findAllByPayment_PaymentMethod(PaymentMethod paymentMethod);

    //Write a derived query to get all orders by specific customer email

    List<Order> findDistinctByCustomer_Email(String email);

    //Write a derived query to check is there any orders by customer email

    //Boolean existsByCustomer_Email();

    //Write a native query to get all orders by specific product name

    @Query(value = "SELECT * FROM orders o JOIN cart c ON o.cart_id = c.id" +
            "JOIN cart_item ci ON ci.cart_id = c.id" +
            "JOIN product p ON ci.product_id = p.id" +
            "WHERE p.name = ?1", nativeQuery = true)
    List<Order> fetchAllByProductName(@Param("name") String name);

    //Write a native query to get all orders by specific categoryId

    @Query(value = "select * from orders join cart_item ci on orders.cart_id = ci.cart_id\n" +
            "join product p on p.id = ci.product_id\n" +
            "join category c on p.id = c.id\n" +
            "where c.id = ?1", nativeQuery = true)
    List<Order> fetchOrdersBySpecificCategoryId(Long id);

    //Write a derived query to get all orders by totalPrice and paidPrice are equals

    @Query("select  o from Order o where  o.paidPrice = o.totalPrice")
            List<Order> listAllOrdersIfTotalPriceAndPaidPriceEquals();

    //Write a derived query to get all orders by totalPrice and paidPrice are not equals and discount is not null

    @Query("select o from Order  o where o.paidPrice <> o.totalPrice and o.cart.discount is not null")
    List<Order> findAllByPaidPriceAndTotalPriceIsNotEqualsAndCart_Discount_IdIsNull();




}
