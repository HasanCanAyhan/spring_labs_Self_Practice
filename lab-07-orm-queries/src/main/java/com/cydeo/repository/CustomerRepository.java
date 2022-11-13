package com.cydeo.repository;

import com.cydeo.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {
    //Write a derived query to get  customer by id

    Optional<Customer> findById(Long id);

    //Write a JPQL query to get customer by email

    @Query("select c from Customer c where c.email = ?1 ")
    Optional<Customer> getCustomerWithEmail(@Param("email") String email);

}
