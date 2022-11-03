package com.cydeo.repository;


import com.cydeo.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface AddressRepository extends JpaRepository<Address,Long> {
    //Write a derived query to get all address with a specific customer
    List<Address> findAllByCustomerId(Long customerId);

    //Write a derived query to get address with a specific street
    Address findAllByStreet(String street);
    //Write a derived query to get top 3 address with a specific customer email
    List<Address> findTop3ByCustomer_Email(String email);
    //Write a derived query to get all address with a specific customer and name

    List<Address> findAllByCustomer_UserName(String username);

    //Write a derived query to list all address where the beginning of the street contains the keyword

    List<Address> findAllByStreetStartingWith(String keyword);

    //Write a JPQL query to get all address with a specific customerId

    @Query("select a from Address a where a.customer.id = ?1")
    List<Address> fetchAllAddressByCustomerId(@Param("id") Long id);
}
