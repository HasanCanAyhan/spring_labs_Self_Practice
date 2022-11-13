package com.cydeo.repository;


import com.cydeo.entity.Address;
import com.cydeo.entity.Balance;
import com.cydeo.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface BalanceRepository extends JpaRepository<Balance,Long> {
    //Write a derived query to check balance exists for specific customer
    Boolean existsBalanceByCustomerId(Long customerId);
    Boolean existsByCustomer(Customer customer);

    //Write a derived query to get balance for specific customer
    Balance findByCustomerId(Long customerId);
    Balance findByCustomer(Customer customer);


    //Write a native query to get top 5 max balance
    @Query(value = "select * from balance order by amount desc " +
            "offset (select count(*) from balance where amount is null ) limit 5;",nativeQuery = true)
    List<Balance> fetchMax5Balance();

    //"select distinct * from balance where amount is not null order by amount desc limit 5"



    //Write a derived query to get all balances greater than or equal specific balance amount

    List<Balance> findAllByAmountGreaterThanEqual(BigDecimal amount);

    //Write a native query to get all balances less than specific balance amount
    @Query(value = "select * from balance where amount < ?1",nativeQuery = true)
    List<Balance> fetchBalancesLessThan(BigDecimal amount);

}
